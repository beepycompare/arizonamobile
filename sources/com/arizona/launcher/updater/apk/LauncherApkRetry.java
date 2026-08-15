package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkRetry;", "", "failedAttempt", "", "nextAttempt", "delayMs", "", "error", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "<init>", "(IIJLcom/arizona/launcher/updater/apk/LauncherApkDownloadError;)V", "getFailedAttempt", "()I", "getNextAttempt", "getDelayMs", "()J", "getError", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkRetry {
    public static final int $stable = 8;
    private final long delayMs;
    private final LauncherApkDownloadError error;
    private final int failedAttempt;
    private final int nextAttempt;

    public static /* synthetic */ LauncherApkRetry copy$default(LauncherApkRetry launcherApkRetry, int i, int i2, long j, LauncherApkDownloadError launcherApkDownloadError, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = launcherApkRetry.failedAttempt;
        }
        if ((i3 & 2) != 0) {
            i2 = launcherApkRetry.nextAttempt;
        }
        if ((i3 & 4) != 0) {
            j = launcherApkRetry.delayMs;
        }
        if ((i3 & 8) != 0) {
            launcherApkDownloadError = launcherApkRetry.error;
        }
        LauncherApkDownloadError launcherApkDownloadError2 = launcherApkDownloadError;
        return launcherApkRetry.copy(i, i2, j, launcherApkDownloadError2);
    }

    public final int component1() {
        return this.failedAttempt;
    }

    public final int component2() {
        return this.nextAttempt;
    }

    public final long component3() {
        return this.delayMs;
    }

    public final LauncherApkDownloadError component4() {
        return this.error;
    }

    public final LauncherApkRetry copy(int i, int i2, long j, LauncherApkDownloadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new LauncherApkRetry(i, i2, j, error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkRetry) {
            LauncherApkRetry launcherApkRetry = (LauncherApkRetry) obj;
            return this.failedAttempt == launcherApkRetry.failedAttempt && this.nextAttempt == launcherApkRetry.nextAttempt && this.delayMs == launcherApkRetry.delayMs && Intrinsics.areEqual(this.error, launcherApkRetry.error);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.failedAttempt) * 31) + Integer.hashCode(this.nextAttempt)) * 31) + Long.hashCode(this.delayMs)) * 31) + this.error.hashCode();
    }

    public String toString() {
        int i = this.failedAttempt;
        int i2 = this.nextAttempt;
        long j = this.delayMs;
        return "LauncherApkRetry(failedAttempt=" + i + ", nextAttempt=" + i2 + ", delayMs=" + j + ", error=" + this.error + ")";
    }

    public LauncherApkRetry(int i, int i2, long j, LauncherApkDownloadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.failedAttempt = i;
        this.nextAttempt = i2;
        this.delayMs = j;
        this.error = error;
    }

    public final int getFailedAttempt() {
        return this.failedAttempt;
    }

    public final int getNextAttempt() {
        return this.nextAttempt;
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public final LauncherApkDownloadError getError() {
        return this.error;
    }
}
