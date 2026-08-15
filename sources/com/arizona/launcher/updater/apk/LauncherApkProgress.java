package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "", "downloadedBytes", "", "totalBytes", "attempt", "", "resumed", "", "<init>", "(JLjava/lang/Long;IZ)V", "getDownloadedBytes", "()J", "getTotalBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAttempt", "()I", "getResumed", "()Z", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/Long;IZ)Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "equals", "other", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkProgress {
    public static final int $stable = 0;
    private final int attempt;
    private final long downloadedBytes;
    private final boolean resumed;
    private final Long totalBytes;

    public static /* synthetic */ LauncherApkProgress copy$default(LauncherApkProgress launcherApkProgress, long j, Long l, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = launcherApkProgress.downloadedBytes;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            l = launcherApkProgress.totalBytes;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            i = launcherApkProgress.attempt;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = launcherApkProgress.resumed;
        }
        return launcherApkProgress.copy(j2, l2, i3, z);
    }

    public final long component1() {
        return this.downloadedBytes;
    }

    public final Long component2() {
        return this.totalBytes;
    }

    public final int component3() {
        return this.attempt;
    }

    public final boolean component4() {
        return this.resumed;
    }

    public final LauncherApkProgress copy(long j, Long l, int i, boolean z) {
        return new LauncherApkProgress(j, l, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkProgress) {
            LauncherApkProgress launcherApkProgress = (LauncherApkProgress) obj;
            return this.downloadedBytes == launcherApkProgress.downloadedBytes && Intrinsics.areEqual(this.totalBytes, launcherApkProgress.totalBytes) && this.attempt == launcherApkProgress.attempt && this.resumed == launcherApkProgress.resumed;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.downloadedBytes) * 31;
        Long l = this.totalBytes;
        return ((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.attempt)) * 31) + Boolean.hashCode(this.resumed);
    }

    public String toString() {
        long j = this.downloadedBytes;
        Long l = this.totalBytes;
        int i = this.attempt;
        return "LauncherApkProgress(downloadedBytes=" + j + ", totalBytes=" + l + ", attempt=" + i + ", resumed=" + this.resumed + ")";
    }

    public LauncherApkProgress(long j, Long l, int i, boolean z) {
        this.downloadedBytes = j;
        this.totalBytes = l;
        this.attempt = i;
        this.resumed = z;
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final Long getTotalBytes() {
        return this.totalBytes;
    }

    public final int getAttempt() {
        return this.attempt;
    }

    public final boolean getResumed() {
        return this.resumed;
    }
}
