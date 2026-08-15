package com.arizona.launcher;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.apk.LauncherApkFailurePolicy;
import com.arizona.launcher.updater.apk.LauncherApkOutcome;
import com.arizona.launcher.updater.apk.LauncherApkProgress;
import com.arizona.launcher.updater.apk.LauncherApkRetry;
import com.arizona.launcher.updater.apk.LauncherUpdateCheckOutcome;
import com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks;
import com.arizona.launcher.updater.apk.LauncherUpdatePhase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"com/arizona/launcher/LauncherUpdateServiceFlow$callbacks$1", "Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;", "onCheckOutcome", "", "token", "", "outcome", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "onApkOutcome", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "onApkProgress", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "onApkRetry", "retry", "Lcom/arizona/launcher/updater/apk/LauncherApkRetry;", "onCancelled", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/apk/LauncherUpdatePhase;", "onUnexpectedFailure", "error", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateServiceFlow$callbacks$1 implements LauncherUpdateControllerCallbacks {
    final /* synthetic */ LauncherUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LauncherUpdateServiceFlow$callbacks$1(LauncherUpdateServiceFlow launcherUpdateServiceFlow) {
        this.this$0 = launcherUpdateServiceFlow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCheckOutcome$lambda$0(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherUpdateCheckOutcome launcherUpdateCheckOutcome) {
        launcherUpdateServiceFlow.handleCheckOutcome(j, launcherUpdateCheckOutcome);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onCheckOutcome(final long j, final LauncherUpdateCheckOutcome outcome) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onCheckOutcome$lambda$0(LauncherUpdateServiceFlow.this, j, outcome);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onApkOutcome$lambda$1(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherApkOutcome launcherApkOutcome) {
        launcherUpdateServiceFlow.handleApkOutcome(j, launcherApkOutcome);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onApkOutcome(final long j, final LauncherApkOutcome outcome) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onApkOutcome$lambda$1(LauncherUpdateServiceFlow.this, j, outcome);
            }
        });
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onApkProgress(final long j, final LauncherApkProgress progress) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(progress, "progress");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onApkProgress$lambda$2(LauncherUpdateServiceFlow.this, j, progress);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onApkProgress$lambda$2(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherApkProgress launcherApkProgress) {
        LauncherUpdateServiceHost launcherUpdateServiceHost;
        LauncherUpdateServiceHost launcherUpdateServiceHost2;
        launcherUpdateServiceHost = launcherUpdateServiceFlow.host;
        if (launcherUpdateServiceHost.isCurrentLauncherApkOperation(j)) {
            launcherUpdateServiceHost2 = launcherUpdateServiceFlow.host;
            launcherUpdateServiceHost2.updateLauncherProgress(launcherApkProgress.getDownloadedBytes(), launcherApkProgress.getTotalBytes(), launcherApkProgress.getAttempt(), launcherApkProgress.getResumed());
        }
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onApkRetry(final long j, final LauncherApkRetry retry) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(retry, "retry");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onApkRetry$lambda$3(LauncherUpdateServiceFlow.this, j, retry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onApkRetry$lambda$3(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherApkRetry launcherApkRetry) {
        LauncherUpdateServiceHost launcherUpdateServiceHost;
        launcherUpdateServiceHost = launcherUpdateServiceFlow.host;
        if (!launcherUpdateServiceHost.isCurrentLauncherApkOperation(j)) {
            return Unit.INSTANCE;
        }
        int failedAttempt = launcherApkRetry.getFailedAttempt();
        int nextAttempt = launcherApkRetry.getNextAttempt();
        long delayMs = launcherApkRetry.getDelayMs();
        Log.w(LauncherUpdateServiceFlow.TAG, "Retry launcher APK: failedAttempt=" + failedAttempt + ", nextAttempt=" + nextAttempt + ", delayMs=" + delayMs + ", failure=" + LauncherApkFailurePolicy.INSTANCE.classify(launcherApkRetry.getError()).getLabel());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCancelled$lambda$4(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherUpdatePhase launcherUpdatePhase) {
        launcherUpdateServiceFlow.handleCancellation(j, launcherUpdatePhase);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onCancelled(final long j, final LauncherUpdatePhase phase) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(phase, "phase");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onCancelled$lambda$4(LauncherUpdateServiceFlow.this, j, phase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onUnexpectedFailure$lambda$5(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, LauncherUpdatePhase launcherUpdatePhase, Throwable th) {
        launcherUpdateServiceFlow.handleUnexpectedFailure(j, launcherUpdatePhase, th);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks
    public void onUnexpectedFailure(final long j, final LauncherUpdatePhase phase, final Throwable error) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(error, "error");
        function1 = this.this$0.postToMain;
        final LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$callbacks$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LauncherUpdateServiceFlow$callbacks$1.onUnexpectedFailure$lambda$5(LauncherUpdateServiceFlow.this, j, phase, error);
            }
        });
    }
}
