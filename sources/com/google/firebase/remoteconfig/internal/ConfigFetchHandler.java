package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ConfigFetchHandler {
    static final String FIRST_OPEN_TIME_KEY = "_fot";
    static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final String X_FIREBASE_RC_FETCH_TYPE = "X-Firebase-RC-Fetch-Type";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final Clock clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigSharedPrefsClient frcSharedPrefs;
    private final Random randomGenerator;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};

    private boolean isThrottleableServerError(int i) {
        return i == HTTP_TOO_MANY_REQUESTS || i == 502 || i == 503 || i == 504;
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigSharedPrefsClient configSharedPrefsClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider;
        this.executor = executor;
        this.clock = clock;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcSharedPrefs = configSharedPrefsClient;
        this.customHttpHeaders = map;
    }

    public Task<FetchResponse> fetch() {
        return fetch(this.frcSharedPrefs.getMinimumFetchIntervalInSeconds());
    }

    public Task<FetchResponse> fetch(final long j) {
        final HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, FetchType.BASE.getValue() + "/1");
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ConfigFetchHandler.this.m8283x7459e696(j, hashMap, task);
            }
        });
    }

    public Task<FetchResponse> fetchNowWithTypeAndAttemptNumber(FetchType fetchType, int i) {
        final HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, fetchType.getValue() + RemoteSettings.FORWARD_SLASH_STRING + i);
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ConfigFetchHandler.this.m8286xdbe8963a(hashMap, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchNowWithTypeAndAttemptNumber$1$com-google-firebase-remoteconfig-internal-ConfigFetchHandler  reason: not valid java name */
    public /* synthetic */ Task m8286xdbe8963a(Map map, Task task) throws Exception {
        return m8283x7459e696(task, 0L, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchIfCacheExpiredAndNotThrottled */
    public Task<FetchResponse> m8283x7459e696(Task<ConfigContainer> task, long j, final Map<String, String> map) {
        final ConfigFetchHandler configFetchHandler;
        Task continueWithTask;
        final Date date = new Date(this.clock.currentTimeMillis());
        if (task.isSuccessful() && areCachedFetchConfigsValid(j, date)) {
            return Tasks.forResult(FetchResponse.forLocalStorageUsed(date));
        }
        Date backoffEndTimeInMillis = getBackoffEndTimeInMillis(date);
        if (backoffEndTimeInMillis != null) {
            continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(backoffEndTimeInMillis.getTime() - date.getTime()), backoffEndTimeInMillis.getTime()));
            configFetchHandler = this;
        } else {
            final Task<String> id = this.firebaseInstallations.getId();
            final Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            configFetchHandler = this;
            continueWithTask = Tasks.whenAllComplete(id, token).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return ConfigFetchHandler.this.m8284x5d615250(id, token, date, map, task2);
                }
            });
        }
        return continueWithTask.continueWithTask(configFetchHandler.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return ConfigFetchHandler.this.m8285xf19fc1ef(date, task2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchIfCacheExpiredAndNotThrottled$2$com-google-firebase-remoteconfig-internal-ConfigFetchHandler  reason: not valid java name */
    public /* synthetic */ Task m8284x5d615250(Task task, Task task2, Date date, Map map, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));
        }
        return fetchFromBackendAndCacheResponse((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).getToken(), date, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchIfCacheExpiredAndNotThrottled$3$com-google-firebase-remoteconfig-internal-ConfigFetchHandler  reason: not valid java name */
    public /* synthetic */ Task m8285xf19fc1ef(Date date, Task task) throws Exception {
        updateLastFetchStatusAndTime(task, date);
        return task;
    }

    private boolean areCachedFetchConfigsValid(long j, Date date) {
        Date lastSuccessfulFetchTime = this.frcSharedPrefs.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigSharedPrefsClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return false;
        }
        return date.before(new Date(lastSuccessfulFetchTime.getTime() + TimeUnit.SECONDS.toMillis(j)));
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcSharedPrefs.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private String createThrottledMessage(long j) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j)));
    }

    private Task<FetchResponse> fetchFromBackendAndCacheResponse(String str, String str2, Date date, Map<String, String> map) {
        try {
            final FetchResponse fetchFromBackend = fetchFromBackend(str, str2, date, map);
            if (fetchFromBackend.getStatus() != 0) {
                return Tasks.forResult(fetchFromBackend);
            }
            return this.fetchedConfigsCache.put(fetchFromBackend.getFetchedConfigs()).onSuccessTask(this.executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task forResult;
                    ConfigContainer configContainer = (ConfigContainer) obj;
                    forResult = Tasks.forResult(ConfigFetchHandler.FetchResponse.this);
                    return forResult;
                }
            });
        } catch (FirebaseRemoteConfigException e) {
            return Tasks.forException(e);
        }
    }

    private FetchResponse fetchFromBackend(String str, String str2, Date date, Map<String, String> map) throws FirebaseRemoteConfigException {
        Date date2;
        try {
            date2 = date;
        } catch (FirebaseRemoteConfigServerException e) {
            e = e;
            date2 = date;
        }
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcSharedPrefs.getLastFetchETag(), map, getFirstOpenTime(), date2, this.frcSharedPrefs.getCustomSignals());
            if (fetch.getFetchedConfigs() != null) {
                this.frcSharedPrefs.setLastTemplateVersion(fetch.getFetchedConfigs().getTemplateVersionNumber());
            }
            if (fetch.getLastFetchETag() != null) {
                this.frcSharedPrefs.setLastFetchETag(fetch.getLastFetchETag());
            }
            this.frcSharedPrefs.resetBackoff();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e2) {
            e = e2;
            FirebaseRemoteConfigServerException firebaseRemoteConfigServerException = e;
            ConfigSharedPrefsClient.BackoffMetadata updateAndReturnBackoffMetadata = updateAndReturnBackoffMetadata(firebaseRemoteConfigServerException.getHttpStatusCode(), date2);
            if (shouldThrottle(updateAndReturnBackoffMetadata, firebaseRemoteConfigServerException.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(updateAndReturnBackoffMetadata.getBackoffEndTime().getTime());
            }
            throw createExceptionWithGenericMessage(firebaseRemoteConfigServerException);
        }
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (httpStatusCode == HTTP_TOO_MANY_REQUESTS) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else {
            if (httpStatusCode == 500) {
                str = "There was an internal server error.";
            } else {
                switch (httpStatusCode) {
                    case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                    case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                    case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            }
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), "Fetch failed: ".concat(str), firebaseRemoteConfigServerException);
    }

    private ConfigSharedPrefsClient.BackoffMetadata updateAndReturnBackoffMetadata(int i, Date date) {
        if (isThrottleableServerError(i)) {
            updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcSharedPrefs.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int numFailedFetches = this.frcSharedPrefs.getBackoffMetadata().getNumFailedFetches() + 1;
        this.frcSharedPrefs.setBackoffMetadata(numFailedFetches, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedFetches)));
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        long millis = timeUnit.toMillis(iArr[Math.min(i, iArr.length) - 1]);
        return (millis / 2) + this.randomGenerator.nextInt((int) millis);
    }

    private boolean shouldThrottle(ConfigSharedPrefsClient.BackoffMetadata backoffMetadata, int i) {
        return backoffMetadata.getNumFailedFetches() > 1 || i == HTTP_TOO_MANY_REQUESTS;
    }

    private void updateLastFetchStatusAndTime(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.frcSharedPrefs.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.frcSharedPrefs.updateLastFetchAsThrottled();
        } else {
            this.frcSharedPrefs.updateLastFetchAsFailed();
        }
    }

    private Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
        if (analyticsConnector != null) {
            for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    private Long getFirstOpenTime() {
        AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.getUserProperties(true).get(FIRST_OPEN_TIME_KEY);
    }

    public long getTemplateVersionNumber() {
        return this.frcSharedPrefs.getLastTemplateVersion();
    }

    public Provider<AnalyticsConnector> getAnalyticsConnector() {
        return this.analyticsConnector;
    }

    /* loaded from: classes4.dex */
    public static class FetchResponse {
        private final Date fetchTime;
        private final ConfigContainer fetchedConfigs;
        private final String lastFetchETag;
        private final int status;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i, ConfigContainer configContainer, String str) {
            this.fetchTime = date;
            this.status = i;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forBackendHasNoUpdates(Date date, ConfigContainer configContainer) {
            return new FetchResponse(date, 1, configContainer, null);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        Date getFetchTime() {
            return this.fetchTime;
        }

        String getLastFetchETag() {
            return this.lastFetchETag;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getStatus() {
            return this.status;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }
    }

    /* loaded from: classes4.dex */
    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");
        
        private final String value;

        FetchType(String str) {
            this.value = str;
        }

        String getValue() {
            return this.value;
        }
    }
}
