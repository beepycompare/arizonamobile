package com.arizona.launcher.updater.apk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;", "", "onCheckOutcome", "", "token", "", "outcome", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "onApkOutcome", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "onApkProgress", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "onApkRetry", "retry", "Lcom/arizona/launcher/updater/apk/LauncherApkRetry;", "onCancelled", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/apk/LauncherUpdatePhase;", "onUnexpectedFailure", "error", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherUpdateControllerCallbacks {
    default void onApkOutcome(long j, LauncherApkOutcome outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
    }

    default void onApkProgress(long j, LauncherApkProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
    }

    default void onApkRetry(long j, LauncherApkRetry retry) {
        Intrinsics.checkNotNullParameter(retry, "retry");
    }

    default void onCancelled(long j, LauncherUpdatePhase phase) {
        Intrinsics.checkNotNullParameter(phase, "phase");
    }

    default void onCheckOutcome(long j, LauncherUpdateCheckOutcome outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
    }

    default void onUnexpectedFailure(long j, LauncherUpdatePhase phase, Throwable error) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onCheckOutcome(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherUpdateCheckOutcome outcome) {
            Intrinsics.checkNotNullParameter(outcome, "outcome");
            LauncherUpdateControllerCallbacks.super.onCheckOutcome(j, outcome);
        }

        @Deprecated
        public static void onApkOutcome(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherApkOutcome outcome) {
            Intrinsics.checkNotNullParameter(outcome, "outcome");
            LauncherUpdateControllerCallbacks.super.onApkOutcome(j, outcome);
        }

        @Deprecated
        public static void onApkProgress(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherApkProgress progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            LauncherUpdateControllerCallbacks.super.onApkProgress(j, progress);
        }

        @Deprecated
        public static void onApkRetry(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherApkRetry retry) {
            Intrinsics.checkNotNullParameter(retry, "retry");
            LauncherUpdateControllerCallbacks.super.onApkRetry(j, retry);
        }

        @Deprecated
        public static void onCancelled(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherUpdatePhase phase) {
            Intrinsics.checkNotNullParameter(phase, "phase");
            LauncherUpdateControllerCallbacks.super.onCancelled(j, phase);
        }

        @Deprecated
        public static void onUnexpectedFailure(LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks, long j, LauncherUpdatePhase phase, Throwable error) {
            Intrinsics.checkNotNullParameter(phase, "phase");
            Intrinsics.checkNotNullParameter(error, "error");
            LauncherUpdateControllerCallbacks.super.onUnexpectedFailure(j, phase, error);
        }
    }
}
