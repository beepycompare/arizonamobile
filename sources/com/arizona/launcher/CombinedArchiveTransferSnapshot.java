package com.arizona.launcher;

import kotlin.Metadata;
/* compiled from: CombinedArchiveTransferProgress.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/CombinedArchiveTransferSnapshot;", "", "completedOffsetBytes", "", "activeLaneTotalBytes", "remainingLaterLaneBytes", "combinedTotalBytes", "<init>", "(JJJJ)V", "getCompletedOffsetBytes", "()J", "getActiveLaneTotalBytes", "getRemainingLaterLaneBytes", "getCombinedTotalBytes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedArchiveTransferSnapshot {
    public static final int $stable = 0;
    private final long activeLaneTotalBytes;
    private final long combinedTotalBytes;
    private final long completedOffsetBytes;
    private final long remainingLaterLaneBytes;

    public static /* synthetic */ CombinedArchiveTransferSnapshot copy$default(CombinedArchiveTransferSnapshot combinedArchiveTransferSnapshot, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = combinedArchiveTransferSnapshot.completedOffsetBytes;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = combinedArchiveTransferSnapshot.activeLaneTotalBytes;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = combinedArchiveTransferSnapshot.remainingLaterLaneBytes;
        }
        return combinedArchiveTransferSnapshot.copy(j5, j6, j3, (i & 8) != 0 ? combinedArchiveTransferSnapshot.combinedTotalBytes : j4);
    }

    public final long component1() {
        return this.completedOffsetBytes;
    }

    public final long component2() {
        return this.activeLaneTotalBytes;
    }

    public final long component3() {
        return this.remainingLaterLaneBytes;
    }

    public final long component4() {
        return this.combinedTotalBytes;
    }

    public final CombinedArchiveTransferSnapshot copy(long j, long j2, long j3, long j4) {
        return new CombinedArchiveTransferSnapshot(j, j2, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CombinedArchiveTransferSnapshot) {
            CombinedArchiveTransferSnapshot combinedArchiveTransferSnapshot = (CombinedArchiveTransferSnapshot) obj;
            return this.completedOffsetBytes == combinedArchiveTransferSnapshot.completedOffsetBytes && this.activeLaneTotalBytes == combinedArchiveTransferSnapshot.activeLaneTotalBytes && this.remainingLaterLaneBytes == combinedArchiveTransferSnapshot.remainingLaterLaneBytes && this.combinedTotalBytes == combinedArchiveTransferSnapshot.combinedTotalBytes;
        }
        return false;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.completedOffsetBytes) * 31) + Long.hashCode(this.activeLaneTotalBytes)) * 31) + Long.hashCode(this.remainingLaterLaneBytes)) * 31) + Long.hashCode(this.combinedTotalBytes);
    }

    public String toString() {
        long j = this.completedOffsetBytes;
        long j2 = this.activeLaneTotalBytes;
        long j3 = this.remainingLaterLaneBytes;
        return "CombinedArchiveTransferSnapshot(completedOffsetBytes=" + j + ", activeLaneTotalBytes=" + j2 + ", remainingLaterLaneBytes=" + j3 + ", combinedTotalBytes=" + this.combinedTotalBytes + ")";
    }

    public CombinedArchiveTransferSnapshot(long j, long j2, long j3, long j4) {
        this.completedOffsetBytes = j;
        this.activeLaneTotalBytes = j2;
        this.remainingLaterLaneBytes = j3;
        this.combinedTotalBytes = j4;
    }

    public final long getCompletedOffsetBytes() {
        return this.completedOffsetBytes;
    }

    public final long getActiveLaneTotalBytes() {
        return this.activeLaneTotalBytes;
    }

    public final long getRemainingLaterLaneBytes() {
        return this.remainingLaterLaneBytes;
    }

    public final long getCombinedTotalBytes() {
        return this.combinedTotalBytes;
    }
}
