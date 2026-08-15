package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveTransferProgressTracker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveTransferProgressTracker;", "", "<init>", "()V", "positionBytes", "", "hasAttemptSample", "", "reset", "", "sample", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveTransferProgressSample;", "downloadedBytes", "totalBytes", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveTransferProgressTracker {
    public static final int $stable = 8;
    private boolean hasAttemptSample;
    private long positionBytes;

    public static /* synthetic */ void reset$default(ArchiveTransferProgressTracker archiveTransferProgressTracker, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        archiveTransferProgressTracker.reset(j);
    }

    public final void reset(long j) {
        this.positionBytes = RangesKt.coerceAtLeast(j, 0L);
        this.hasAttemptSample = false;
    }

    public final ArchiveTransferProgressSample sample(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j2, 0L);
        long max = Math.max(RangesKt.coerceAtMost(this.positionBytes, coerceAtLeast), RangesKt.coerceIn(j, 0L, coerceAtLeast));
        long coerceAtLeast2 = this.hasAttemptSample ? RangesKt.coerceAtLeast(max - this.positionBytes, 0L) : 0L;
        this.positionBytes = max;
        this.hasAttemptSample = true;
        return new ArchiveTransferProgressSample(max, coerceAtLeast, coerceAtLeast2);
    }
}
