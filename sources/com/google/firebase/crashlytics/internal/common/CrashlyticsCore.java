package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes4.dex */
public class CrashlyticsCore {
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 3;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_STACK_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin";
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final String ON_DEMAND_DROPPED_KEY = "com.crashlytics.on-demand.dropped-exceptions";
    private static final String ON_DEMAND_RECORDED_KEY = "com.crashlytics.on-demand.recorded-exceptions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final FirebaseApp app;
    public final BreadcrumbSource breadcrumbSource;
    private final Context context;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private final CrashlyticsWorkers crashlyticsWorkers;
    private final DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final FileStore fileStore;
    private final IdManager idManager;
    private CrashlyticsFileMarker initializationMarker;
    private final CrashlyticsNativeComponent nativeComponent;
    private final RemoteConfigDeferredProxy remoteConfigDeferredProxy;
    private final CrashlyticsAppQualitySessionsSubscriber sessionsSubscriber;
    private final long startTime = System.currentTimeMillis();
    private final OnDemandCounter onDemandCounter = new OnDemandCounter();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, RemoteConfigDeferredProxy remoteConfigDeferredProxy, CrashlyticsWorkers crashlyticsWorkers) {
        this.app = firebaseApp;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.context = firebaseApp.getApplicationContext();
        this.idManager = idManager;
        this.nativeComponent = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource;
        this.analyticsEventLogger = analyticsEventLogger;
        this.fileStore = fileStore;
        this.sessionsSubscriber = crashlyticsAppQualitySessionsSubscriber;
        this.remoteConfigDeferredProxy = remoteConfigDeferredProxy;
        this.crashlyticsWorkers = crashlyticsWorkers;
    }

    public boolean onPreExecute(AppData appData, SettingsProvider settingsProvider) {
        if (!isBuildIdValid(appData.buildId, CommonUtils.getBooleanResourceValue(this.context, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
            throw new IllegalStateException(MISSING_BUILD_ID_MSG);
        }
        String sessionId = new CLSUUID().getSessionId();
        try {
            this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, this.fileStore);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
            UserMetadata userMetadata = new UserMetadata(sessionId, this.fileStore, this.crashlyticsWorkers);
            LogFileManager logFileManager = new LogFileManager(this.fileStore);
            MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
            this.remoteConfigDeferredProxy.setupListener(userMetadata);
            this.controller = new CrashlyticsController(this.context, this.idManager, this.dataCollectionArbiter, this.fileStore, this.crashMarker, appData, userMetadata, logFileManager, SessionReportingCoordinator.create(this.context, this.idManager, this.fileStore, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsProvider, this.onDemandCounter, this.sessionsSubscriber, this.crashlyticsWorkers), this.nativeComponent, this.analyticsEventLogger, this.sessionsSubscriber, this.crashlyticsWorkers);
            boolean didPreviousInitializationFail = didPreviousInitializationFail();
            checkForPreviousCrash();
            this.controller.enableExceptionHandling(sessionId, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
            if (didPreviousInitializationFail && CommonUtils.canTryConnection(this.context)) {
                Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously(settingsProvider);
                return false;
            }
            Logger.getLogger().d("Successfully configured exception handler.");
            return true;
        } catch (Exception e) {
            Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", e);
            this.controller = null;
            return false;
        }
    }

    public Task<Void> doBackgroundInitializationAsync(final SettingsProvider settingsProvider) {
        return this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8228x16e6f122(settingsProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doBackgroundInitialization */
    public void m8229x1097325b(SettingsProvider settingsProvider) {
        CrashlyticsWorkers.checkBackgroundThread();
        markInitializationStarted();
        try {
            this.breadcrumbSource.registerBreadcrumbHandler(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda3
                @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                public final void handleBreadcrumb(String str) {
                    CrashlyticsCore.this.log(str);
                }
            });
            this.controller.saveVersionControlInfo();
            if (!settingsProvider.getSettingsSync().featureFlagData.collectReports) {
                Logger.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
            }
            if (!this.controller.finalizeSessions(settingsProvider)) {
                Logger.getLogger().w("Previous sessions could not be finalized.");
            }
            this.controller.submitAllReports(settingsProvider.getSettingsAsync());
        } catch (Exception e) {
            Logger.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            markInitializationComplete();
        }
    }

    public boolean isCrashlyticsCollectionEnabled() {
        return this.dataCollectionArbiter.isAutomaticDataCollectionEnabled();
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(bool);
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    public Task<Void> sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    public Task<Void> deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    public static String getVersion() {
        return "19.4.4";
    }

    public void logException(final Throwable th, final Map<String, String> map) {
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8232xa7aaa7c5(th, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logException$1$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8232xa7aaa7c5(Throwable th, Map map) {
        this.controller.writeNonFatalException(Thread.currentThread(), th, map);
    }

    public void log(final String str) {
        final long currentTimeMillis = System.currentTimeMillis() - this.startTime;
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8231xc4d7d9c6(currentTimeMillis, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$log$2$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8230x771861c5(long j, String str) {
        this.controller.writeToLog(j, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$log$3$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8231xc4d7d9c6(final long j, final String str) {
        this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8230x771861c5(j, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setUserId$4$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8237xff792c8b(String str) {
        this.controller.setUserId(str);
    }

    public void setUserId(final String str) {
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8237xff792c8b(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCustomKey$5$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8234xd965350a(String str, String str2) {
        this.controller.setCustomKey(str, str2);
    }

    public void setCustomKey(final String str, final String str2) {
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8234xd965350a(str, str2);
            }
        });
    }

    public void setCustomKeys(final Map<String, String> map) {
        if (map.isEmpty()) {
            return;
        }
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8235x42c2b50c(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCustomKeys$6$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8235x42c2b50c(Map map) {
        this.controller.setCustomKeys(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setInternalKey$7$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8236xed193680(String str, String str2) {
        this.controller.setInternalKey(str, str2);
    }

    public void setInternalKey(final String str, final String str2) {
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8236xed193680(str, str2);
            }
        });
    }

    public void logFatalException(final Throwable th) {
        Logger.getLogger().d("Recorded on-demand fatal events: " + this.onDemandCounter.getRecordedOnDemandExceptions());
        Logger.getLogger().d("Dropped on-demand fatal events: " + this.onDemandCounter.getDroppedOnDemandExceptions());
        this.crashlyticsWorkers.common.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8233xae266e96(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logFatalException$8$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ void m8233xae266e96(Throwable th) {
        this.controller.setInternalKey(ON_DEMAND_RECORDED_KEY, Integer.toString(this.onDemandCounter.getRecordedOnDemandExceptions()));
        this.controller.setInternalKey(ON_DEMAND_DROPPED_KEY, Integer.toString(this.onDemandCounter.getDroppedOnDemandExceptions()));
        this.controller.logFatalException(Thread.currentThread(), th);
    }

    CrashlyticsController getController() {
        return this.controller;
    }

    private void finishInitSynchronously(final SettingsProvider settingsProvider) {
        Future<?> submit = this.crashlyticsWorkers.common.getExecutor().submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.this.m8229x1097325b(settingsProvider);
            }
        });
        Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Logger.getLogger().e("Crashlytics was interrupted during initialization.", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            Logger.getLogger().e("Crashlytics encountered a problem during initialization.", e2);
        } catch (TimeoutException e3) {
            Logger.getLogger().e("Crashlytics timed out during initialization.", e3);
        }
    }

    void markInitializationStarted() {
        CrashlyticsWorkers.checkBackgroundThread();
        this.initializationMarker.create();
        Logger.getLogger().v("Initialization marker file was created.");
    }

    void markInitializationComplete() {
        CrashlyticsWorkers.checkBackgroundThread();
        try {
            if (this.initializationMarker.remove()) {
                return;
            }
            Logger.getLogger().w("Initialization marker file was not properly removed.");
        } catch (Exception e) {
            Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e);
        }
    }

    boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    private void checkForPreviousCrash() {
        try {
            this.didCrashOnPreviousExecution = Boolean.TRUE.equals((Boolean) this.crashlyticsWorkers.common.getExecutor().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda10
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return CrashlyticsCore.this.m8227xf5be8161();
                }
            }).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.didCrashOnPreviousExecution = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkForPreviousCrash$10$com-google-firebase-crashlytics-internal-common-CrashlyticsCore  reason: not valid java name */
    public /* synthetic */ Boolean m8227xf5be8161() throws Exception {
        return Boolean.valueOf(this.controller.didCrashOnPreviousExecution());
    }

    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            Logger.getLogger().v("Configured not to require a build ID.");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".     |  | ");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".   \\ |  | /");
            Log.e(Logger.TAG, ".    \\    /");
            Log.e(Logger.TAG, ".     \\  /");
            Log.e(Logger.TAG, ".      \\/");
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, MISSING_BUILD_ID_MSG);
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".      /\\");
            Log.e(Logger.TAG, ".     /  \\");
            Log.e(Logger.TAG, ".    /    \\");
            Log.e(Logger.TAG, ".   / |  | \\");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".");
            return false;
        } else {
            return true;
        }
    }
}
