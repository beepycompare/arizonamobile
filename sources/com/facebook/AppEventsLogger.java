package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.Request;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_PERIOD_IN_SECONDS = 60;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG = "com.facebook.AppEventsLogger";
    private static Context applicationContext;
    private static Timer flushTimer;
    private static boolean requestInFlight;
    private static Timer supportsAttributionRecheckTimer;
    private final AccessTokenAppIdPair accessTokenAppId;
    private final Context context;
    private static Map<AccessTokenAppIdPair, SessionEventsState> stateMap = new ConcurrentHashMap();
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static Object staticLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class AccessTokenAppIdPair implements Serializable {
        private static final long serialVersionUID = 1;
        private final String accessToken;
        private final String applicationId;

        /* loaded from: classes3.dex */
        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final String accessToken;
            private final String appId;

            private SerializationProxyV1(String str, String str2) {
                this.accessToken = str;
                this.appId = str2;
            }

            /* synthetic */ SerializationProxyV1(String str, String str2, SerializationProxyV1 serializationProxyV1) {
                this(str, str2);
            }

            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessToken, this.appId);
            }
        }

        AccessTokenAppIdPair(Session session) {
            this(session.getAccessToken(), session.getApplicationId());
        }

        AccessTokenAppIdPair(String str, String str2) {
            this.accessToken = Utility.isNullOrEmpty(str) ? null : str;
            this.applicationId = str2;
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.accessToken, this.applicationId, null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof AccessTokenAppIdPair) {
                AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
                return Utility.areObjectsEqual(accessTokenAppIdPair.accessToken, this.accessToken) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId);
            }
            return false;
        }

        String getAccessToken() {
            return this.accessToken;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        public int hashCode() {
            String str = this.accessToken;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.applicationId;
            return hashCode ^ (str2 != null ? str2.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AppEvent implements Serializable {
        private static final long serialVersionUID = 1;
        private static final HashSet<String> validatedIdentifiers = new HashSet<>();
        private boolean isImplicit;
        private JSONObject jsonObject;

        /* loaded from: classes3.dex */
        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final boolean isImplicit;
            private final String jsonString;

            private SerializationProxyV1(String str, boolean z) {
                this.jsonString = str;
                this.isImplicit = z;
            }

            /* synthetic */ SerializationProxyV1(String str, boolean z, SerializationProxyV1 serializationProxyV1) {
                this(str, z);
            }

            private Object readResolve() throws JSONException {
                return new AppEvent(this.jsonString, this.isImplicit, null);
            }
        }

        public AppEvent(String str, Double d, Bundle bundle, boolean z) {
            validateIdentifier(str);
            this.isImplicit = z;
            JSONObject jSONObject = new JSONObject();
            this.jsonObject = jSONObject;
            try {
                jSONObject.put("_eventName", str);
                this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000);
                if (d != null) {
                    this.jsonObject.put("_valueToSum", d.doubleValue());
                }
                if (this.isImplicit) {
                    this.jsonObject.put("_implicitlyLogged", "1");
                }
                String appVersion = Settings.getAppVersion();
                if (appVersion != null) {
                    this.jsonObject.put("_appVersion", appVersion);
                }
                if (bundle != null) {
                    for (String str2 : bundle.keySet()) {
                        validateIdentifier(str2);
                        Object obj = bundle.get(str2);
                        if (!(obj instanceof String) && !(obj instanceof Number)) {
                            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str2));
                        }
                        this.jsonObject.put(str2, obj.toString());
                    }
                }
                if (this.isImplicit) {
                    return;
                }
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
                this.jsonObject = null;
            }
        }

        private AppEvent(String str, boolean z) throws JSONException {
            this.jsonObject = new JSONObject(str);
            this.isImplicit = z;
        }

        /* synthetic */ AppEvent(String str, boolean z, AppEvent appEvent) throws JSONException {
            this(str, z);
        }

        private void validateIdentifier(String str) {
            boolean contains;
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format("Identifier '%s' must be less than %d characters", str, 40));
            }
            HashSet<String> hashSet = validatedIdentifiers;
            synchronized (hashSet) {
                contains = hashSet.contains(str);
            }
            if (contains) {
                return;
            }
            if (!str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
            }
            synchronized (hashSet) {
                hashSet.add(str);
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.jsonObject.toString(), this.isImplicit, null);
        }

        public boolean getIsImplicit() {
            return this.isImplicit;
        }

        public JSONObject getJSONObject() {
            return this.jsonObject;
        }

        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
        }
    }

    /* loaded from: classes3.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FlushBehavior[] valuesCustom() {
            FlushBehavior[] valuesCustom = values();
            int length = valuesCustom.length;
            FlushBehavior[] flushBehaviorArr = new FlushBehavior[length];
            System.arraycopy(valuesCustom, 0, flushBehaviorArr, 0, length);
            return flushBehaviorArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum FlushReason {
        EXPLICIT,
        TIMER,
        SESSION_CHANGE,
        PERSISTED_EVENTS,
        EVENT_THRESHOLD,
        EAGER_FLUSHING_EVENT;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FlushReason[] valuesCustom() {
            FlushReason[] valuesCustom = values();
            int length = valuesCustom.length;
            FlushReason[] flushReasonArr = new FlushReason[length];
            System.arraycopy(valuesCustom, 0, flushReasonArr, 0, length);
            return flushReasonArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum FlushResult {
        SUCCESS,
        SERVER_ERROR,
        NO_CONNECTIVITY,
        UNKNOWN_ERROR;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FlushResult[] valuesCustom() {
            FlushResult[] valuesCustom = values();
            int length = valuesCustom.length;
            FlushResult[] flushResultArr = new FlushResult[length];
            System.arraycopy(valuesCustom, 0, flushResultArr, 0, length);
            return flushResultArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class FlushStatistics {
        public int numEvents;
        public FlushResult result;

        private FlushStatistics() {
            this.numEvents = 0;
            this.result = FlushResult.SUCCESS;
        }

        /* synthetic */ FlushStatistics(FlushStatistics flushStatistics) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PersistedEvents {
        static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
        private static Object staticLock = new Object();
        private Context context;
        private HashMap<AccessTokenAppIdPair, List<AppEvent>> persistedEvents = new HashMap<>();

        private PersistedEvents(Context context) {
            this.context = context;
        }

        public static void persistEvents(Context context, AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
            HashMap hashMap = new HashMap();
            hashMap.put(accessTokenAppIdPair, sessionEventsState);
            persistEvents(context, hashMap);
        }

        public static void persistEvents(Context context, Map<AccessTokenAppIdPair, SessionEventsState> map) {
            synchronized (staticLock) {
                PersistedEvents readAndClearStore = readAndClearStore(context);
                for (Map.Entry<AccessTokenAppIdPair, SessionEventsState> entry : map.entrySet()) {
                    List<AppEvent> eventsToPersist = entry.getValue().getEventsToPersist();
                    if (eventsToPersist.size() != 0) {
                        readAndClearStore.addEvents(entry.getKey(), eventsToPersist);
                    }
                }
                readAndClearStore.write();
            }
        }

        public static PersistedEvents readAndClearStore(Context context) {
            PersistedEvents persistedEvents;
            synchronized (staticLock) {
                persistedEvents = new PersistedEvents(context);
                persistedEvents.readAndClearStore();
            }
            return persistedEvents;
        }

        private void readAndClearStore() {
            ObjectInputStream objectInputStream;
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(this.context.openFileInput(PERSISTED_EVENTS_FILENAME)));
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e = e;
            }
            try {
                this.context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                this.persistedEvents = (HashMap) objectInputStream.readObject();
                Utility.closeQuietly(objectInputStream);
            } catch (FileNotFoundException unused2) {
                objectInputStream2 = objectInputStream;
                Utility.closeQuietly(objectInputStream2);
            } catch (Exception e2) {
                e = e2;
                objectInputStream2 = objectInputStream;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectInputStream2);
            } catch (Throwable th2) {
                th = th2;
                Utility.closeQuietly(objectInputStream);
                throw th;
            }
        }

        private void write() {
            ObjectOutputStream objectOutputStream;
            Throwable th;
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(this.context.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
                } catch (Throwable th2) {
                    objectOutputStream = null;
                    th = th2;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                objectOutputStream.writeObject(this.persistedEvents);
                Utility.closeQuietly(objectOutputStream);
            } catch (Exception e2) {
                e = e2;
                objectOutputStream2 = objectOutputStream;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        }

        public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
            if (!this.persistedEvents.containsKey(accessTokenAppIdPair)) {
                this.persistedEvents.put(accessTokenAppIdPair, new ArrayList());
            }
            this.persistedEvents.get(accessTokenAppIdPair).addAll(list);
        }

        public List<AppEvent> getEvents(AccessTokenAppIdPair accessTokenAppIdPair) {
            return this.persistedEvents.get(accessTokenAppIdPair);
        }

        public Set<AccessTokenAppIdPair> keySet() {
            return this.persistedEvents.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SessionEventsState {
        public static final String ENCODED_EVENTS_KEY = "encoded_events";
        public static final String EVENT_COUNT_KEY = "event_count";
        public static final String NUM_SKIPPED_KEY = "num_skipped";
        private String attributionId;
        private int numSkippedEventsDueToFullBuffer;
        private String packageName;
        private List<AppEvent> accumulatedEvents = new ArrayList();
        private List<AppEvent> inFlightEvents = new ArrayList();
        private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;

        public SessionEventsState(String str, String str2) {
            this.attributionId = str;
            this.packageName = str2;
        }

        private byte[] getStringAsByteArray(String str) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                Utility.logd("Encoding exception: ", e);
                return null;
            }
        }

        private void populateRequest(Request request, int i, JSONArray jSONArray, boolean z, boolean z2) {
            String str;
            GraphObject create = GraphObject.Factory.create();
            create.setProperty(NotificationCompat.CATEGORY_EVENT, "CUSTOM_APP_EVENTS");
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                create.setProperty("num_skipped_events", Integer.valueOf(i));
            }
            if (z && (str = this.attributionId) != null) {
                create.setProperty("attribution", str);
            }
            create.setProperty("application_tracking_enabled", Boolean.valueOf(!z2));
            create.setProperty("application_package_name", this.packageName);
            request.setGraphObject(create);
            Bundle parameters = request.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                parameters.putByteArray("custom_events_file", getStringAsByteArray(jSONArray2));
                request.setTag(jSONArray2);
            }
            request.setParameters(parameters);
        }

        public void accumulatePersistedEvents(List<AppEvent> list) {
            synchronized (this) {
                this.accumulatedEvents.addAll(list);
            }
        }

        public void addEvent(AppEvent appEvent) {
            synchronized (this) {
                if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
                    this.numSkippedEventsDueToFullBuffer++;
                } else {
                    this.accumulatedEvents.add(appEvent);
                }
            }
        }

        public void clearInFlightAndStats(boolean z) {
            synchronized (this) {
                if (z) {
                    this.accumulatedEvents.addAll(this.inFlightEvents);
                }
                this.inFlightEvents.clear();
                this.numSkippedEventsDueToFullBuffer = 0;
            }
        }

        public int getAccumulatedEventCount() {
            int size;
            synchronized (this) {
                size = this.accumulatedEvents.size();
            }
            return size;
        }

        public List<AppEvent> getEventsToPersist() {
            List<AppEvent> list;
            synchronized (this) {
                list = this.accumulatedEvents;
                this.accumulatedEvents = new ArrayList();
            }
            return list;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005e -> B:26:0x005b). Please submit an issue!!! */
        public int populateRequest(Request request, boolean z, boolean z2, boolean z3) {
            Throwable th;
            synchronized (this) {
                try {
                    int i = this.numSkippedEventsDueToFullBuffer;
                    this.inFlightEvents.addAll(this.accumulatedEvents);
                    this.accumulatedEvents.clear();
                    JSONArray jSONArray = new JSONArray();
                    for (AppEvent appEvent : this.inFlightEvents) {
                        Request request2 = request;
                        boolean z4 = z2;
                        boolean z5 = z3;
                        try {
                            if (!z && appEvent.getIsImplicit()) {
                                request = request2;
                                z2 = z4;
                                z3 = z5;
                            }
                            jSONArray.put(appEvent.getJSONObject());
                            request = request2;
                            z2 = z4;
                            z3 = z5;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            throw th;
                        }
                    }
                    if (jSONArray.length() != 0) {
                        populateRequest(request, i, jSONArray, z2, z3);
                        return jSONArray.length();
                    }
                    try {
                        return 0;
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    throw th;
                }
            }
        }
    }

    private AppEventsLogger(Context context, String str, Session session) {
        Validate.notNull(context, "context");
        this.context = context;
        session = session == null ? Session.getActiveSession() : session;
        if (session != null) {
            this.accessTokenAppId = new AccessTokenAppIdPair(session);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str == null ? Utility.getMetadataApplicationId(context) : str);
        }
        synchronized (staticLock) {
            if (applicationContext == null) {
                applicationContext = context.getApplicationContext();
            }
        }
        initializeTimersIfNeeded();
    }

    private static int accumulatePersistedEvents() {
        PersistedEvents readAndClearStore = PersistedEvents.readAndClearStore(applicationContext);
        int i = 0;
        for (AccessTokenAppIdPair accessTokenAppIdPair : readAndClearStore.keySet()) {
            SessionEventsState sessionEventsState = getSessionEventsState(applicationContext, accessTokenAppIdPair);
            List<AppEvent> events = readAndClearStore.getEvents(accessTokenAppIdPair);
            sessionEventsState.accumulatePersistedEvents(events);
            i += events.size();
        }
        return i;
    }

    public static void activateApp(Context context) {
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void activateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        Settings.publishInstallAsync(context, str);
        new AppEventsLogger(context, str, null).logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP);
    }

    private static FlushStatistics buildAndExecuteRequests(FlushReason flushReason, Set<AccessTokenAppIdPair> set) {
        Request buildRequestForSession;
        FlushStatistics flushStatistics = new FlushStatistics(null);
        boolean limitEventUsage = getLimitEventUsage(applicationContext);
        ArrayList<Request> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
            SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null && (buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventUsage, flushStatistics)) != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() > 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
            for (Request request : arrayList) {
                request.executeAndWait();
            }
            return flushStatistics;
        }
        return null;
    }

    private static Request buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        String applicationId = accessTokenAppIdPair.getApplicationId();
        Utility.FetchedAppSettings queryAppSettings = Utility.queryAppSettings(applicationId, false);
        final Request newPostRequest = Request.newPostRequest(null, String.format("%s/activities", applicationId), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessToken());
        newPostRequest.setParameters(parameters);
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, queryAppSettings.supportsImplicitLogging(), queryAppSettings.supportsAttribution(), z);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents += populateRequest;
        newPostRequest.setCallback(new Request.Callback() { // from class: com.facebook.AppEventsLogger.4
            @Override // com.facebook.Request.Callback
            public void onCompleted(Response response) {
                AppEventsLogger.handleResponse(AccessTokenAppIdPair.this, newPostRequest, response, sessionEventsState, flushStatistics);
            }
        });
        return newPostRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void flush(final FlushReason flushReason) {
        Settings.getExecutor().execute(new Runnable() { // from class: com.facebook.AppEventsLogger.3
            @Override // java.lang.Runnable
            public void run() {
                AppEventsLogger.flushAndWait(FlushReason.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flushAndWait(FlushReason flushReason) {
        FlushStatistics flushStatistics;
        synchronized (staticLock) {
            if (requestInFlight) {
                return;
            }
            requestInFlight = true;
            HashSet hashSet = new HashSet(stateMap.keySet());
            accumulatePersistedEvents();
            try {
                flushStatistics = buildAndExecuteRequests(flushReason, hashSet);
            } catch (Exception e) {
                Log.d(TAG, "Caught unexpected exception while flushing: " + e.toString());
                flushStatistics = null;
            }
            synchronized (staticLock) {
                requestInFlight = false;
            }
            if (flushStatistics != null) {
                Intent intent = new Intent(ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, flushStatistics.numEvents);
                intent.putExtra(APP_EVENTS_EXTRA_FLUSH_RESULT, flushStatistics.result);
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent);
            }
        }
    }

    private static void flushIfNecessary() {
        synchronized (staticLock) {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > 100) {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
    }

    private static int getAccumulatedEventCount() {
        int i;
        synchronized (staticLock) {
            i = 0;
            for (SessionEventsState sessionEventsState : stateMap.values()) {
                i += sessionEventsState.getAccumulatedEventCount();
            }
        }
        return i;
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    public static boolean getLimitEventUsage(Context context) {
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    private static SessionEventsState getSessionEventsState(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (staticLock) {
            sessionEventsState = stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                sessionEventsState = new SessionEventsState(Settings.getAttributionId(context.getContentResolver()), context.getPackageName());
                stateMap.put(accessTokenAppIdPair, sessionEventsState);
            }
        }
        return sessionEventsState;
    }

    private static SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (staticLock) {
            sessionEventsState = stateMap.get(accessTokenAppIdPair);
        }
        return sessionEventsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, Request request, Response response, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        String str;
        String str2;
        FacebookRequestError error = response.getError();
        FlushResult flushResult = FlushResult.SUCCESS;
        if (error == null) {
            str = "Success";
        } else if (error.getErrorCode() == -1) {
            flushResult = FlushResult.NO_CONNECTIVITY;
            str = "Failed: No Connectivity";
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", response.toString(), error.toString());
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str2 = new JSONArray((String) request.getTag()).toString(2);
            } catch (JSONException unused) {
                str2 = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.getGraphObject().toString(), str, str2);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            PersistedEvents.persistEvents(applicationContext, accessTokenAppIdPair, sessionEventsState);
        }
        if (flushResult == FlushResult.SUCCESS || flushStatistics.result == FlushResult.NO_CONNECTIVITY) {
            return;
        }
        flushStatistics.result = flushResult;
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (flushTimer != null) {
                return;
            }
            flushTimer = new Timer();
            supportsAttributionRecheckTimer = new Timer();
            flushTimer.schedule(new TimerTask() { // from class: com.facebook.AppEventsLogger.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        AppEventsLogger.flushAndWait(FlushReason.TIMER);
                    }
                }
            }, 0L, 60000L);
            supportsAttributionRecheckTimer.schedule(new TimerTask() { // from class: com.facebook.AppEventsLogger.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    HashSet<String> hashSet = new HashSet();
                    synchronized (AppEventsLogger.staticLock) {
                        for (AccessTokenAppIdPair accessTokenAppIdPair : AppEventsLogger.stateMap.keySet()) {
                            hashSet.add(accessTokenAppIdPair.getApplicationId());
                        }
                    }
                    for (String str : hashSet) {
                        Utility.queryAppSettings(str, true);
                    }
                }
            }, 0L, CalendarModelKt.MillisecondsIn24Hours);
        }
    }

    private static void logEvent(Context context, AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        getSessionEventsState(context, accessTokenAppIdPair).addEvent(appEvent);
        flushIfNecessary();
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z) {
        logEvent(this.context, new AppEvent(str, d, bundle, z), this.accessTokenAppId);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, Session session) {
        return new AppEventsLogger(context, null, session);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static AppEventsLogger newLogger(Context context, String str, Session session) {
        return new AppEventsLogger(context, str, session);
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    public static void onContextStop() {
        PersistedEvents.persistEvents(applicationContext, stateMap);
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public static void setLimitEventUsage(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit();
        edit.putBoolean("limitEventUsage", z);
        edit.commit();
    }

    public void flush() {
        flush(FlushReason.EXPLICIT);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidForSession(Session session) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(session));
    }

    public void logEvent(String str) {
        logEvent(str, (Bundle) null);
    }

    public void logEvent(String str, double d) {
        logEvent(str, d, (Bundle) null);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        logEvent(str, Double.valueOf(d), bundle, false);
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        logPurchase(bigDecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, bigDecimal.doubleValue(), bundle);
            eagerFlush();
        }
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        logEvent(str, d, bundle, true);
    }
}
