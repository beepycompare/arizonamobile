package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateTransferProgress.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/UpdateTransferProgressSnapshot;", "", "totalBytes", "", "downloadedBytes", "displayedDownloadedBytes", "speedLabel", "", "estimatedRemainingMillis", "<init>", "(JJJLjava/lang/String;Ljava/lang/Long;)V", "getTotalBytes", "()J", "getDownloadedBytes", "getDisplayedDownloadedBytes", "getSpeedLabel", "()Ljava/lang/String;", "getEstimatedRemainingMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(JJJLjava/lang/String;Ljava/lang/Long;)Lcom/arizona/launcher/UpdateTransferProgressSnapshot;", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateTransferProgressSnapshot {
    public static final int $stable = 0;
    private final long displayedDownloadedBytes;
    private final long downloadedBytes;
    private final Long estimatedRemainingMillis;
    private final String speedLabel;
    private final long totalBytes;

    public static /* synthetic */ UpdateTransferProgressSnapshot copy$default(UpdateTransferProgressSnapshot updateTransferProgressSnapshot, long j, long j2, long j3, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = updateTransferProgressSnapshot.totalBytes;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = updateTransferProgressSnapshot.downloadedBytes;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = updateTransferProgressSnapshot.displayedDownloadedBytes;
        }
        return updateTransferProgressSnapshot.copy(j4, j5, j3, (i & 8) != 0 ? updateTransferProgressSnapshot.speedLabel : str, (i & 16) != 0 ? updateTransferProgressSnapshot.estimatedRemainingMillis : l);
    }

    public final long component1() {
        return this.totalBytes;
    }

    public final long component2() {
        return this.downloadedBytes;
    }

    public final long component3() {
        return this.displayedDownloadedBytes;
    }

    public final String component4() {
        return this.speedLabel;
    }

    public final Long component5() {
        return this.estimatedRemainingMillis;
    }

    public final UpdateTransferProgressSnapshot copy(long j, long j2, long j3, String speedLabel, Long l) {
        Intrinsics.checkNotNullParameter(speedLabel, "speedLabel");
        return new UpdateTransferProgressSnapshot(j, j2, j3, speedLabel, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateTransferProgressSnapshot) {
            UpdateTransferProgressSnapshot updateTransferProgressSnapshot = (UpdateTransferProgressSnapshot) obj;
            return this.totalBytes == updateTransferProgressSnapshot.totalBytes && this.downloadedBytes == updateTransferProgressSnapshot.downloadedBytes && this.displayedDownloadedBytes == updateTransferProgressSnapshot.displayedDownloadedBytes && Intrinsics.areEqual(this.speedLabel, updateTransferProgressSnapshot.speedLabel) && Intrinsics.areEqual(this.estimatedRemainingMillis, updateTransferProgressSnapshot.estimatedRemainingMillis);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.totalBytes) * 31) + Long.hashCode(this.downloadedBytes)) * 31) + Long.hashCode(this.displayedDownloadedBytes)) * 31) + this.speedLabel.hashCode()) * 31;
        Long l = this.estimatedRemainingMillis;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        long j = this.totalBytes;
        long j2 = this.downloadedBytes;
        long j3 = this.displayedDownloadedBytes;
        String str = this.speedLabel;
        return "UpdateTransferProgressSnapshot(totalBytes=" + j + ", downloadedBytes=" + j2 + ", displayedDownloadedBytes=" + j3 + ", speedLabel=" + str + ", estimatedRemainingMillis=" + this.estimatedRemainingMillis + ")";
    }

    public UpdateTransferProgressSnapshot(long j, long j2, long j3, String speedLabel, Long l) {
        Intrinsics.checkNotNullParameter(speedLabel, "speedLabel");
        this.totalBytes = j;
        this.downloadedBytes = j2;
        this.displayedDownloadedBytes = j3;
        this.speedLabel = speedLabel;
        this.estimatedRemainingMillis = l;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final long getDisplayedDownloadedBytes() {
        return this.displayedDownloadedBytes;
    }

    public final String getSpeedLabel() {
        return this.speedLabel;
    }

    public final Long getEstimatedRemainingMillis() {
        return this.estimatedRemainingMillis;
    }
}
