package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class ConfigAutoFetch {
    private static final int MAXIMUM_FETCH_ATTEMPTS = 3;
    private static final String REALTIME_DISABLED_KEY = "featureDisabled";
    private static final String TEMPLATE_VERSION_KEY = "latestTemplateVersionNumber";
    private final ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;
    private final Set<ConfigUpdateListener> eventListeners;
    private final HttpURLConnection httpURLConnection;
    private final ConfigUpdateListener retryCallback;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Random random = new Random();
    private boolean isInBackground = false;

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService) {
        this.httpURLConnection = httpURLConnection;
        this.configFetchHandler = configFetchHandler;
        this.activatedCache = configCacheClient;
        this.eventListeners = set;
        this.retryCallback = configUpdateListener;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener configUpdateListener : this.eventListeners) {
            configUpdateListener.onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void executeAllListenerCallbacks(ConfigUpdate configUpdate) {
        for (ConfigUpdateListener configUpdateListener : this.eventListeners) {
            configUpdateListener.onUpdate(configUpdate);
        }
    }

    private synchronized boolean isEventListenersEmpty() {
        return this.eventListeners.isEmpty();
    }

    public void setIsInBackground(boolean z) {
        this.isInBackground = z;
    }

    private String parseAndValidateConfigUpdateMessage(String str) {
        int indexOf = str.indexOf(123);
        int lastIndexOf = str.lastIndexOf(125);
        if (indexOf < 0 || lastIndexOf < 0 || indexOf >= lastIndexOf) {
            return "";
        }
        return str.substring(indexOf, lastIndexOf + 1);
    }

    public void listenForNotifications() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection == null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    handleNotifications(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    Log.d(FirebaseRemoteConfig.TAG, "Exception thrown when closing connection stream. Retrying connection...", e);
                }
            } catch (IOException e2) {
                if (!this.isInBackground) {
                    Log.d(FirebaseRemoteConfig.TAG, "Real-time connection was closed due to an exception.", e2);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    Log.d(FirebaseRemoteConfig.TAG, "Exception thrown when closing connection stream. Retrying connection...", e3);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        r4 = new org.json.JSONObject(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (r4.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r4.getBoolean(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        r8.retryCallback.onError(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (isEventListenersEmpty() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r4.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        r5 = r8.configFetchHandler.getTemplateVersionNumber();
        r3 = r4.getLong(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        if (r3 <= r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        autoFetch(3, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleNotifications(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        loop0: while (true) {
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                str = str + readLine;
                if (readLine.contains("}")) {
                    str = parseAndValidateConfigUpdateMessage(str);
                    if (!str.isEmpty()) {
                        try {
                            break;
                        } catch (JSONException e) {
                            propagateErrors(new FirebaseRemoteConfigClientException("Unable to parse config update message.", e.getCause(), FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID));
                            Log.e(FirebaseRemoteConfig.TAG, "Unable to parse latest config update message.", e);
                        }
                    }
                }
            }
        }
        bufferedReader.close();
    }

    private void autoFetch(final int i, final long j) {
        if (i == 0) {
            propagateErrors(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
            return;
        }
        this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
            @Override // java.lang.Runnable
            public void run() {
                ConfigAutoFetch.this.fetchLatestConfig(i, j);
            }
        }, this.random.nextInt(4), TimeUnit.SECONDS);
    }

    public synchronized Task<Void> fetchLatestConfig(int i, final long j) {
        final int i2 = i - 1;
        try {
            try {
                final Task<ConfigFetchHandler.FetchResponse> fetchNowWithTypeAndAttemptNumber = this.configFetchHandler.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i2);
                final Task<ConfigContainer> task = this.activatedCache.get();
                return Tasks.whenAllComplete(fetchNowWithTypeAndAttemptNumber, task).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task2) {
                        return ConfigAutoFetch.this.m8281xc4c7076e(fetchNowWithTypeAndAttemptNumber, task, j, i2, task2);
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchLatestConfig$0$com-google-firebase-remoteconfig-internal-ConfigAutoFetch  reason: not valid java name */
    public /* synthetic */ Task m8281xc4c7076e(Task task, Task task2, long j, int i, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainer = (ConfigContainer) task2.getResult();
        if (!fetchResponseIsUpToDate(fetchResponse, j).booleanValue()) {
            Log.d(FirebaseRemoteConfig.TAG, "Fetched template version is the same as SDK's current version. Retrying fetch.");
            autoFetch(i, j);
            return Tasks.forResult(null);
        } else if (fetchResponse.getFetchedConfigs() == null) {
            Log.d(FirebaseRemoteConfig.TAG, "The fetch succeeded, but the backend had no updates.");
            return Tasks.forResult(null);
        } else {
            if (configContainer == null) {
                configContainer = ConfigContainer.newBuilder().build();
            }
            Set<String> changedParams = configContainer.getChangedParams(fetchResponse.getFetchedConfigs());
            if (changedParams.isEmpty()) {
                Log.d(FirebaseRemoteConfig.TAG, "Config was fetched, but no params changed.");
                return Tasks.forResult(null);
            }
            executeAllListenerCallbacks(ConfigUpdate.create(changedParams));
            return Tasks.forResult(null);
        }
    }

    private static Boolean fetchResponseIsUpToDate(ConfigFetchHandler.FetchResponse fetchResponse, long j) {
        if (fetchResponse.getFetchedConfigs() != null) {
            return Boolean.valueOf(fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j);
        }
        return Boolean.valueOf(fetchResponse.getStatus() == 1);
    }
}
