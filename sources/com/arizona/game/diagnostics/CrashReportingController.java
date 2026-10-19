package com.arizona.game.diagnostics;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CrashReportingController.kt */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0010\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011Ê\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001c"}, d2 = {"Lcom/arizona/game/diagnostics/CrashReportingController;", "", "activity", "Landroid/app/Activity;", "sources", "Ljava/util/function/IntSupplier;", "<init>", "(Landroid/app/Activity;Ljava/util/function/IntSupplier;)V", "handler", "Landroid/os/Handler;", "resumed", "", "destroyed", "gameStartup", "Ljava/lang/Runnable;", "poll", "com/arizona/game/diagnostics/CrashReportingController$poll$1", "Lcom/arizona/game/diagnostics/CrashReportingController$poll$1;", TtmlNode.START, "", "startup", "onResume", "onPause", "destroy", "refresh", "abandonHandoff", "continueStartup", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrashReportingController {
    @Deprecated
    public static final long CHECK_INTERVAL_MS = 1000;
    @Deprecated
    public static final int DISABLE_REPORTING = 1;
    @Deprecated
    public static final long HANDOFF_TIMEOUT_MS = 10000;
    @Deprecated
    public static final String TAG = "CrashReportingPolicy";
    private static RestartHandoff handoff;
    private static boolean persisting;
    private final Activity activity;
    private boolean destroyed;
    private Runnable gameStartup;
    private final Handler handler;
    private final CrashReportingController$poll$1 poll;
    private boolean resumed;
    private final IntSupplier sources;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ReportingPolicyState state = new ReportingPolicyState();
    private static final ExecutorService persistenceExecutor = Executors.newSingleThreadExecutor();

    /* JADX WARN: Type inference failed for: r2v2, types: [com.arizona.game.diagnostics.CrashReportingController$poll$1] */
    public CrashReportingController(Activity activity, IntSupplier sources) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sources, "sources");
        this.activity = activity;
        this.sources = sources;
        this.handler = new Handler(Looper.getMainLooper());
        this.poll = new Runnable() { // from class: com.arizona.game.diagnostics.CrashReportingController$poll$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                Handler handler;
                z = CrashReportingController.this.resumed;
                if (z) {
                    z2 = CrashReportingController.this.destroyed;
                    if (z2) {
                        return;
                    }
                    CrashReportingController.this.refresh();
                    handler = CrashReportingController.this.handler;
                    handler.postDelayed(this, 1000L);
                }
            }
        };
    }

    public final void start(Runnable startup) {
        Intrinsics.checkNotNullParameter(startup, "startup");
        this.gameStartup = startup;
        refresh();
        if (state.getRestartRequired()) {
            return;
        }
        continueStartup();
    }

    public final void onResume() {
        this.resumed = true;
        RestartHandoff restartHandoff = handoff;
        if (restartHandoff != null && restartHandoff.getHostPaused()) {
            abandonHandoff();
        }
        this.handler.removeCallbacks(this.poll);
        this.handler.post(this.poll);
    }

    public final void onPause() {
        this.resumed = false;
        RestartHandoff restartHandoff = handoff;
        if (restartHandoff != null) {
            restartHandoff.setHostPaused(true);
        }
        this.handler.removeCallbacks(this.poll);
    }

    public final void destroy() {
        this.destroyed = true;
        onPause();
        this.gameStartup = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        try {
            int asInt = this.sources.getAsInt();
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            Intrinsics.checkNotNullExpressionValue(firebaseCrashlytics, "getInstance(...)");
            ReportingPolicyState reportingPolicyState = state;
            if (reportingPolicyState.observe((asInt & 1) != 0, firebaseCrashlytics.isCrashlyticsCollectionEnabled())) {
                firebaseCrashlytics.setCrashlyticsCollectionEnabled(false);
                firebaseCrashlytics.deleteUnsentReports();
            }
            if (reportingPolicyState.getRestartRequired()) {
                if (reportingPolicyState.getRestartAbandoned()) {
                    continueStartup();
                } else if (reportingPolicyState.getPersistenceReady()) {
                    if (this.resumed && handoff == null) {
                        final RestartHandoff restartHandoff = new RestartHandoff();
                        handoff = restartHandoff;
                        try {
                            ProcessRestartActivity.Companion.launch$app(this.activity, restartHandoff);
                            this.handler.postDelayed(new Runnable() { // from class: com.arizona.game.diagnostics.CrashReportingController$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    CrashReportingController.refresh$lambda$0(RestartHandoff.this, this);
                                }
                            }, 10000L);
                        } catch (RuntimeException e) {
                            Log.e(TAG, "Unable to launch reporting-policy restart", e);
                            abandonHandoff();
                        }
                    }
                } else if (persisting) {
                } else {
                    persisting = true;
                    final Context applicationContext = this.activity.getApplicationContext();
                    persistenceExecutor.execute(new Runnable() { // from class: com.arizona.game.diagnostics.CrashReportingController$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            CrashReportingController.refresh$lambda$1(applicationContext, this);
                        }
                    });
                }
            }
        } catch (UnsatisfiedLinkError e2) {
            Log.w(TAG, "Native reporting policy is unavailable", e2);
            continueStartup();
            onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void refresh$lambda$0(RestartHandoff restartHandoff, CrashReportingController crashReportingController) {
        if (handoff == restartHandoff && restartHandoff.cancelPending()) {
            crashReportingController.abandonHandoff();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void refresh$lambda$1(Context context, final CrashReportingController crashReportingController) {
        final boolean z;
        try {
            CrashReportingPreferences crashReportingPreferences = CrashReportingPreferences.INSTANCE;
            Intrinsics.checkNotNull(context);
            z = crashReportingPreferences.flushDisabledOverride(context);
        } catch (RuntimeException e) {
            Log.e(TAG, "Unable to persist reporting policy", e);
            z = false;
        }
        crashReportingController.handler.post(new Runnable() { // from class: com.arizona.game.diagnostics.CrashReportingController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CrashReportingController.refresh$lambda$1$0(z, crashReportingController);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$1$0(boolean z, CrashReportingController crashReportingController) {
        persisting = false;
        state.persisted(z);
        if (!z) {
            Log.e(TAG, "Reporting-policy disk barrier failed; process will not be terminated");
            if (crashReportingController.destroyed) {
                return;
            }
            crashReportingController.continueStartup();
        } else if (crashReportingController.destroyed) {
        } else {
            crashReportingController.refresh();
        }
    }

    private final void abandonHandoff() {
        RestartHandoff restartHandoff = handoff;
        if (restartHandoff != null) {
            restartHandoff.cancelPending();
        }
        handoff = null;
        state.abandonRestart();
        Log.w(TAG, "Reporting restart handoff failed; collection remains disabled");
        if (this.destroyed) {
            return;
        }
        continueStartup();
    }

    private final void continueStartup() {
        Runnable runnable = this.gameStartup;
        if (runnable == null) {
            return;
        }
        this.gameStartup = null;
        runnable.run();
    }

    /* compiled from: CrashReportingController.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/arizona/game/diagnostics/CrashReportingController$Companion;", "", "<init>", "()V", "TAG", "", "DISABLE_REPORTING", "", "CHECK_INTERVAL_MS", "", "HANDOFF_TIMEOUT_MS", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/game/diagnostics/ReportingPolicyState;", "getState", "()Lcom/arizona/game/diagnostics/ReportingPolicyState;", "persisting", "", "getPersisting", "()Z", "setPersisting", "(Z)V", "handoff", "Lcom/arizona/game/diagnostics/RestartHandoff;", "getHandoff", "()Lcom/arizona/game/diagnostics/RestartHandoff;", "setHandoff", "(Lcom/arizona/game/diagnostics/RestartHandoff;)V", "persistenceExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getPersistenceExecutor", "()Ljava/util/concurrent/ExecutorService;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReportingPolicyState getState() {
            return CrashReportingController.state;
        }

        public final boolean getPersisting() {
            return CrashReportingController.persisting;
        }

        public final void setPersisting(boolean z) {
            CrashReportingController.persisting = z;
        }

        public final RestartHandoff getHandoff() {
            return CrashReportingController.handoff;
        }

        public final void setHandoff(RestartHandoff restartHandoff) {
            CrashReportingController.handoff = restartHandoff;
        }

        public final ExecutorService getPersistenceExecutor() {
            return CrashReportingController.persistenceExecutor;
        }
    }
}
