package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.Request;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class Settings {
    private static final String ANALYTICS_EVENT = "event";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_KEY = "attribution";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final String AUTO_PUBLISH = "auto_publish";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = "com.facebook.Settings";
    private static volatile String appVersion;
    private static volatile Executor executor;
    private static volatile boolean shouldAutoPublishInstall;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    private static final String FACEBOOK_COM = "facebook.com";
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static final Object LOCK = new Object();
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() { // from class: com.facebook.Settings.1
        private final AtomicInteger counter = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    };

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
        }
    }

    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    private static Executor getAsyncTaskExecutor() {
        try {
            Object obj = AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
            if (obj != null && (obj instanceof Executor)) {
                return (Executor) obj;
            }
            return null;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static String getAttributionId(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("aid"));
        query.close();
        return string;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                Executor asyncTaskExecutor = getAsyncTaskExecutor();
                if (asyncTaskExecutor == null) {
                    asyncTaskExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
                }
                executor = asyncTaskExecutor;
            }
        }
        return executor;
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
        }
        return unmodifiableSet;
    }

    public static String getMigrationBundle() {
        return FacebookSdkVersion.MIGRATION_BUNDLE;
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    @Deprecated
    public static boolean getShouldAutoPublishInstall() {
        return shouldAutoPublishInstall;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean contains;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            contains = hashSet.contains(loggingBehavior);
        }
        return contains;
    }

    @Deprecated
    public static boolean publishInstallAndWait(Context context, String str) {
        Response publishInstallAndWaitForResponse = publishInstallAndWaitForResponse(context, str);
        return publishInstallAndWaitForResponse != null && publishInstallAndWaitForResponse.getError() == null;
    }

    @Deprecated
    public static Response publishInstallAndWaitForResponse(Context context, String str) {
        return publishInstallAndWaitForResponse(context, str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1 A[Catch: Exception -> 0x0113, TRY_ENTER, TryCatch #1 {Exception -> 0x0113, blocks: (B:5:0x0009, B:7:0x004a, B:8:0x004d, B:12:0x0094, B:16:0x00a1, B:18:0x00b7, B:21:0x00bf, B:23:0x00c9, B:25:0x00de, B:27:0x00e8, B:28:0x00f7, B:30:0x00fb, B:31:0x0102, B:32:0x0103, B:33:0x010a, B:34:0x010b, B:35:0x0112), top: B:42:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7 A[Catch: Exception -> 0x0113, TryCatch #1 {Exception -> 0x0113, blocks: (B:5:0x0009, B:7:0x004a, B:8:0x004d, B:12:0x0094, B:16:0x00a1, B:18:0x00b7, B:21:0x00bf, B:23:0x00c9, B:25:0x00de, B:27:0x00e8, B:28:0x00f7, B:30:0x00fb, B:31:0x0102, B:32:0x0103, B:33:0x010a, B:34:0x010b, B:35:0x0112), top: B:42:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Response publishInstallAndWaitForResponse(Context context, String str, boolean z) {
        GraphObject create;
        try {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            String attributionId = getAttributionId(context.getContentResolver());
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String str2 = String.valueOf(str) + "ping";
            String str3 = String.valueOf(str) + "json";
            long j = sharedPreferences.getLong(str2, 0L);
            String string = sharedPreferences.getString(str3, null);
            if (!z) {
                setShouldAutoPublishInstall(false);
            }
            GraphObject create2 = GraphObject.Factory.create();
            create2.setProperty("event", MOBILE_INSTALL_EVENT);
            create2.setProperty(ATTRIBUTION_KEY, attributionId);
            create2.setProperty(AUTO_PUBLISH, Boolean.valueOf(z));
            create2.setProperty("application_tracking_enabled", Boolean.valueOf(!AppEventsLogger.getLimitEventUsage(context)));
            create2.setProperty("application_package_name", context.getPackageName());
            Request newPostRequest = Request.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, str), create2, null);
            if (j == 0) {
                if (attributionId != null) {
                    if (Utility.queryAppSettings(str, false).supportsAttribution()) {
                        Response executeAndWait = newPostRequest.executeAndWait();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(str2, System.currentTimeMillis());
                        if (executeAndWait.getGraphObject() != null && executeAndWait.getGraphObject().getInnerJSONObject() != null) {
                            edit.putString(str3, executeAndWait.getGraphObject().getInnerJSONObject().toString());
                        }
                        edit.commit();
                        return executeAndWait;
                    }
                    throw new FacebookException("Install attribution has been disabled on the server.");
                }
                throw new FacebookException("No attribution id returned from the Facebook application");
            }
            if (string != null) {
                try {
                    create = GraphObject.Factory.create(new JSONObject(string));
                } catch (JSONException unused) {
                }
                return create != null ? Response.createResponsesFromString("true", null, new RequestBatch(newPostRequest), true).get(0) : new Response((Request) null, (HttpURLConnection) null, create, true);
            }
            create = null;
            if (create != null) {
            }
        } catch (Exception e) {
            Utility.logd("Facebook-publish", e);
            return new Response(null, null, new FacebookRequestError(null, e));
        }
    }

    @Deprecated
    public static void publishInstallAsync(Context context, String str) {
        publishInstallAsync(context, str, null);
    }

    @Deprecated
    public static void publishInstallAsync(Context context, final String str, final Request.Callback callback) {
        final Context applicationContext = context.getApplicationContext();
        getExecutor().execute(new Runnable() { // from class: com.facebook.Settings.2
            @Override // java.lang.Runnable
            public void run() {
                final Response publishInstallAndWaitForResponse = Settings.publishInstallAndWaitForResponse(applicationContext, str);
                if (callback != null) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    final Request.Callback callback2 = callback;
                    handler.post(new Runnable() { // from class: com.facebook.Settings.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            callback2.onCompleted(publishInstallAndWaitForResponse);
                        }
                    });
                }
            }
        });
    }

    public static final void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(loggingBehavior);
        }
    }

    public static void setAppVersion(String str) {
        appVersion = str;
    }

    public static void setExecutor(Executor executor2) {
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            executor = executor2;
        }
    }

    public static void setFacebookDomain(String str) {
        facebookDomain = str;
    }

    @Deprecated
    public static void setShouldAutoPublishInstall(boolean z) {
        shouldAutoPublishInstall = z;
    }
}
