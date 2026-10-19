package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: CombinedArchiveTransferProgress.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/CombinedArchiveTransferProgress;", "", "<init>", "()V", "completedOffsetBytes", "", "activeLaneTotalBytes", "remainingLaterLaneBytes", "plannedActiveLaneBytes", "laneTotalFromProgress", "", "reset", "Lcom/arizona/launcher/CombinedArchiveTransferSnapshot;", "beginLane", "laneDownloadBytes", "applyLaneTotal", "laneTotalBytes", "expandLane", "completeActiveLane", "snapshot", "shouldIgnoreStorageExpansion", "proposed", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedArchiveTransferProgress {
    public static final int $stable = 8;
    private long activeLaneTotalBytes;
    private long completedOffsetBytes;
    private boolean laneTotalFromProgress;
    private long plannedActiveLaneBytes;
    private long remainingLaterLaneBytes;

    public final CombinedArchiveTransferSnapshot reset() {
        this.completedOffsetBytes = 0L;
        this.activeLaneTotalBytes = 0L;
        this.remainingLaterLaneBytes = 0L;
        this.plannedActiveLaneBytes = 0L;
        this.laneTotalFromProgress = false;
        return snapshot();
    }

    public final CombinedArchiveTransferSnapshot beginLane(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        this.activeLaneTotalBytes = coerceAtLeast;
        this.remainingLaterLaneBytes = RangesKt.coerceAtLeast(j2, 0L);
        this.plannedActiveLaneBytes = coerceAtLeast;
        this.laneTotalFromProgress = false;
        return snapshot();
    }

    public final CombinedArchiveTransferSnapshot applyLaneTotal(long j, long j2) {
        this.activeLaneTotalBytes = RangesKt.coerceAtLeast(j, 0L);
        this.remainingLaterLaneBytes = RangesKt.coerceAtLeast(j2, 0L);
        this.laneTotalFromProgress = true;
        return snapshot();
    }

    public final CombinedArchiveTransferSnapshot expandLane(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        this.remainingLaterLaneBytes = RangesKt.coerceAtLeast(j2, 0L);
        if (!shouldIgnoreStorageExpansion(coerceAtLeast)) {
            this.activeLaneTotalBytes = Math.max(this.activeLaneTotalBytes, coerceAtLeast);
        }
        return snapshot();
    }

    public final CombinedArchiveTransferSnapshot completeActiveLane() {
        long saturatedAdd;
        saturatedAdd = CombinedArchiveTransferProgressKt.saturatedAdd(this.completedOffsetBytes, this.activeLaneTotalBytes);
        this.completedOffsetBytes = saturatedAdd;
        this.activeLaneTotalBytes = 0L;
        this.plannedActiveLaneBytes = 0L;
        this.laneTotalFromProgress = false;
        return snapshot();
    }

    public final CombinedArchiveTransferSnapshot snapshot() {
        long saturatedAdd;
        long saturatedAdd2;
        long j = this.completedOffsetBytes;
        long j2 = this.activeLaneTotalBytes;
        long j3 = this.remainingLaterLaneBytes;
        saturatedAdd = CombinedArchiveTransferProgressKt.saturatedAdd(j2, j3);
        saturatedAdd2 = CombinedArchiveTransferProgressKt.saturatedAdd(j, saturatedAdd);
        return new CombinedArchiveTransferSnapshot(j, j2, j3, saturatedAdd2);
    }

    private final boolean shouldIgnoreStorageExpansion(long j) {
        return this.laneTotalFromProgress && j > this.activeLaneTotalBytes && j <= this.plannedActiveLaneBytes;
    }
}
