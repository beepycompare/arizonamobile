package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    ConfigCacheClient activatedCache;
    private ConfigAutoFetch configAutoFetch;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private int httpRetriesRemaining;
    private HttpURLConnection httpURLConnection;
    private final Set<ConfigUpdateListener> listeners;
    private final String namespace;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ConfigSharedPrefsClient sharedPrefsClient;
    private final int ORIGINAL_RETRIES = 8;
    private boolean isHttpConnectionRunning = false;
    private final Random random = new Random();
    private final Clock clock = DefaultClock.getInstance();
    private boolean isRealtimeDisabled = false;
    private boolean isInBackground = false;
    private final Object backgroundLock = new Object();

    private boolean isStatusCodeRetryable(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, Set<ConfigUpdateListener> set, ConfigSharedPrefsClient configSharedPrefsClient, ScheduledExecutorService scheduledExecutorService) {
        this.listeners = set;
        this.scheduledExecutorService = scheduledExecutorService;
        this.httpRetriesRemaining = Math.max(8 - configSharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.firebaseApp = firebaseApp;
        this.configFetchHandler = configFetchHandler;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context;
        this.namespace = str;
        this.sharedPrefsClient = configSharedPrefsClient;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes == null) {
                Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
                return null;
            }
            return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(FirebaseRemoteConfig.TAG, "No such package: " + this.context.getPackageName());
            return null;
        }
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, "true");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
    }

    private JSONObject createRequestBody(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        hashMap.put("namespace", this.namespace);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.firebaseApp.getOptions().getApplicationId());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
        return new JSONObject(hashMap);
    }

    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        setCommonRequestHeaders(httpURLConnection, str2);
        byte[] bytes = createRequestBody(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener configUpdateListener : this.listeners) {
            configUpdateListener.onError(firebaseRemoteConfigException);
        }
    }

    public int getNumberOfFailedStreams() {
        return this.sharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams();
    }

    public Date getBackoffEndTime() {
        return this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime();
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.sharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.sharedPrefsClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = iArr.length;
        if (i >= length) {
            i = length;
        }
        long millis = TimeUnit.MINUTES.toMillis(iArr[i - 1]);
        return (millis / 2) + this.random.nextInt((int) millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        boolean z;
        if (!this.listeners.isEmpty() && !this.isHttpConnectionRunning && !this.isRealtimeDisabled) {
            z = this.isInBackground ? false : true;
        }
        return z;
    }

    private String getRealtimeURL(String str) {
        return String.format(RemoteConfigConstants.REALTIME_REGEX_URL, extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), str);
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            Log.e(FirebaseRemoteConfig.TAG, "URL is malformed");
            return null;
        }
    }

    public Task<HttpURLConnection> createRealtimeConnection() {
        final Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
        final Task<String> id = this.firebaseInstallations.getId();
        return Tasks.whenAllComplete(token, id).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ConfigRealtimeHttpClient.this.m8288xad28ecdf(token, id, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createRealtimeConnection$0$com-google-firebase-remoteconfig-internal-ConfigRealtimeHttpClient  reason: not valid java name */
    public /* synthetic */ Task m8288xad28ecdf(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e));
        }
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0L);
    }

    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0L, this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    private synchronized void makeRealtimeHttpConnection(long j) {
        if (canMakeHttpStreamConnection()) {
            int i = this.httpRetriesRemaining;
            if (i > 0) {
                this.httpRetriesRemaining = i - 1;
                this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigRealtimeHttpClient.this.beginRealtimeHttpStream();
                    }
                }, j, TimeUnit.MILLISECONDS);
            } else if (!this.isInBackground) {
                propagateErrors(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
            }
        }
    }

    public void setIsInBackground(boolean z) {
        HttpURLConnection httpURLConnection;
        synchronized (this.backgroundLock) {
            this.isInBackground = z;
            ConfigAutoFetch configAutoFetch = this.configAutoFetch;
            if (configAutoFetch != null) {
                configAutoFetch.setIsInBackground(z);
            }
            if (Build.VERSION.SDK_INT >= 26 && z && (httpURLConnection = this.httpURLConnection) != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private synchronized boolean checkAndSetHttpConnectionFlagIfNotRunning() {
        boolean canMakeHttpStreamConnection;
        canMakeHttpStreamConnection = canMakeHttpStreamConnection();
        if (canMakeHttpStreamConnection) {
            setIsHttpConnectionRunning(true);
        }
        return canMakeHttpStreamConnection;
    }

    private synchronized void setIsHttpConnectionRunning(boolean z) {
        this.isHttpConnectionRunning = z;
    }

    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.2
            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onUpdate(ConfigUpdate configUpdate) {
            }

            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }
        }, this.scheduledExecutorService);
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    public void beginRealtimeHttpStream() {
        if (checkAndSetHttpConnectionFlagIfNotRunning()) {
            if (new Date(this.clock.currentTimeMillis()).before(this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime())) {
                retryHttpConnectionWhenBackoffEnds();
                return;
            }
            final Task<HttpURLConnection> createRealtimeConnection = createRealtimeConnection();
            Tasks.whenAllComplete(createRealtimeConnection).continueWith(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return ConfigRealtimeHttpClient.this.m8287x5fb1dc1(createRealtimeConnection, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cf A[Catch: all -> 0x0139, TryCatch #5 {all -> 0x0139, blocks: (B:8:0x002b, B:10:0x0031, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d3 A[Catch: all -> 0x0139, TRY_LEAVE, TryCatch #5 {all -> 0x0139, blocks: (B:8:0x002b, B:10:0x0031, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0119  */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.android.gms.tasks.Task] */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v33, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: lambda$beginRealtimeHttpStream$1$com-google-firebase-remoteconfig-internal-ConfigRealtimeHttpClient  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Task m8287x5fb1dc1(Task task, Task task2) throws Exception {
        InputStream inputStream;
        Integer num;
        Throwable th;
        ?? r6;
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException;
        boolean z = true;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            e = e;
            task = 0;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            num = null;
            th = th3;
            task = 0;
        }
        if (task.isSuccessful()) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) task.getResult();
            this.httpURLConnection = httpURLConnection;
            task = httpURLConnection.getInputStream();
            try {
                inputStream = this.httpURLConnection.getErrorStream();
                try {
                    r6 = Integer.valueOf(this.httpURLConnection.getResponseCode());
                    try {
                        if (r6.intValue() == 200) {
                            resetRetryCount();
                            this.sharedPrefsClient.resetRealtimeBackoff();
                            ConfigAutoFetch startAutoFetch = startAutoFetch(this.httpURLConnection);
                            this.configAutoFetch = startAutoFetch;
                            startAutoFetch.listenForNotifications();
                        }
                        closeRealtimeHttpConnection(task, inputStream);
                        setIsHttpConnectionRunning(false);
                        if (this.isInBackground || (r6 != 0 && !isStatusCodeRetryable(r6.intValue()))) {
                            z = false;
                        }
                        if (z) {
                            updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (this.isInBackground) {
                            Log.d(FirebaseRemoteConfig.TAG, "Exception connecting to real-time RC backend. Retrying the connection...", e);
                        } else {
                            resetRetryCount();
                        }
                        closeRealtimeHttpConnection(task, inputStream);
                        setIsHttpConnectionRunning(false);
                        if (!this.isInBackground || (r6 != 0 && !isStatusCodeRetryable(r6.intValue()))) {
                            z = false;
                        }
                        if (z) {
                            updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                        }
                        if (!z && r6.intValue() != 200) {
                            String format = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", r6);
                            if (r6.intValue() == 403) {
                                format = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                            }
                            firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(r6.intValue(), format, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                            propagateErrors(firebaseRemoteConfigServerException);
                            this.httpURLConnection = null;
                            this.configAutoFetch = null;
                            return Tasks.forResult(null);
                        }
                        retryHttpConnectionWhenBackoffEnds();
                        this.httpURLConnection = null;
                        this.configAutoFetch = null;
                        return Tasks.forResult(null);
                    }
                } catch (IOException e3) {
                    e = e3;
                    r6 = 0;
                } catch (Throwable th4) {
                    num = null;
                    th = th4;
                    closeRealtimeHttpConnection(task, inputStream);
                    setIsHttpConnectionRunning(false);
                    if (this.isInBackground || (num != null && !isStatusCodeRetryable(num.intValue()))) {
                        z = false;
                    }
                    if (z) {
                        updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                    }
                    if (z || num.intValue() == 200) {
                        retryHttpConnectionWhenBackoffEnds();
                    } else {
                        String format2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            format2 = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                        }
                        propagateErrors(new FirebaseRemoteConfigServerException(num.intValue(), format2, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
                task = task;
                r6 = inputStream;
                if (this.isInBackground) {
                }
                closeRealtimeHttpConnection(task, inputStream);
                setIsHttpConnectionRunning(false);
                if (!this.isInBackground) {
                }
                z = false;
                if (z) {
                }
                if (!z) {
                    String format3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", r6);
                    if (r6.intValue() == 403) {
                    }
                    firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(r6.intValue(), format3, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                    propagateErrors(firebaseRemoteConfigServerException);
                    this.httpURLConnection = null;
                    this.configAutoFetch = null;
                    return Tasks.forResult(null);
                }
                retryHttpConnectionWhenBackoffEnds();
                this.httpURLConnection = null;
                this.configAutoFetch = null;
                return Tasks.forResult(null);
            } catch (Throwable th5) {
                num = null;
                th = th5;
                inputStream = null;
            }
            if (!z && r6.intValue() != 200) {
                String format4 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", r6);
                if (r6.intValue() == 403) {
                    format4 = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                }
                firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(r6.intValue(), format4, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                propagateErrors(firebaseRemoteConfigServerException);
                this.httpURLConnection = null;
                this.configAutoFetch = null;
                return Tasks.forResult(null);
            }
            retryHttpConnectionWhenBackoffEnds();
            this.httpURLConnection = null;
            this.configAutoFetch = null;
            return Tasks.forResult(null);
        }
        throw new IOException(task.getException());
    }

    private void closeHttpConnectionInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.d(FirebaseRemoteConfig.TAG, "Error closing connection stream.", e);
            }
        }
    }

    public void closeRealtimeHttpConnection(InputStream inputStream, InputStream inputStream2) {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null && !this.isInBackground) {
            httpURLConnection.disconnect();
        }
        closeHttpConnectionInputStream(inputStream);
        closeHttpConnectionInputStream(inputStream2);
    }
}
