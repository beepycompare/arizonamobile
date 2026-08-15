package com.arizona.launcher;

import com.arizona.launcher.updater.apk.LauncherApkProgress;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveTransferProgressSample;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveTransferProgressTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: UpdateTransferProgress.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0000¨\u0006 "}, d2 = {"Lcom/arizona/launcher/UpdateTransferProgress;", "", "speedMeterFactory", "Lkotlin/Function0;", "Lcom/arizona/launcher/TransferSpeedMeter;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "archiveProgressTracker", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveTransferProgressTracker;", "totalBytes", "", "downloadedBytes", "displayedDownloadedBytes", "speedMeter", "launcherAttempt", "", "launcherAttemptPositionBytes", "beginArchive", "Lcom/arizona/launcher/UpdateTransferProgressSnapshot;", "resetArchiveMirror", "remainingBytes", "onArchiveProgress", "expandTotalBytes", "atLeastBytes", "beginLauncher", "onLauncherProgress", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "complete", "snapshot", "resetTransfer", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateTransferProgress {
    public static final int $stable = 8;
    private final ArchiveTransferProgressTracker archiveProgressTracker;
    private long displayedDownloadedBytes;
    private long downloadedBytes;
    private int launcherAttempt;
    private long launcherAttemptPositionBytes;
    private TransferSpeedMeter speedMeter;
    private final Function0<TransferSpeedMeter> speedMeterFactory;
    private long totalBytes;

    public UpdateTransferProgress() {
        this(null, 1, null);
    }

    public UpdateTransferProgress(Function0<TransferSpeedMeter> speedMeterFactory) {
        Intrinsics.checkNotNullParameter(speedMeterFactory, "speedMeterFactory");
        this.speedMeterFactory = speedMeterFactory;
        this.archiveProgressTracker = new ArchiveTransferProgressTracker();
    }

    public /* synthetic */ UpdateTransferProgress(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.arizona.launcher.UpdateTransferProgress$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateTransferProgress._init_$lambda$0();
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TransferSpeedMeter _init_$lambda$0() {
        return new TransferSpeedMeter(null, 0L, 3, null);
    }

    public final UpdateTransferProgressSnapshot beginArchive(long j) {
        ArchiveTransferProgressTracker.reset$default(this.archiveProgressTracker, 0L, 1, null);
        this.launcherAttempt = 0;
        this.launcherAttemptPositionBytes = 0L;
        resetTransfer(j);
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot resetArchiveMirror(long j) {
        ArchiveTransferProgressTracker.reset$default(this.archiveProgressTracker, 0L, 1, null);
        resetTransfer(j);
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot onArchiveProgress(long j, long j2) {
        ArchiveTransferProgressSample sample = this.archiveProgressTracker.sample(j, j2);
        TransferSpeedMeter transferSpeedMeter = this.speedMeter;
        if (transferSpeedMeter != null) {
            transferSpeedMeter.addBytes(sample.getSpeedDeltaBytes());
        }
        this.totalBytes = sample.getTotalBytes();
        this.downloadedBytes = sample.getDownloadedBytes();
        this.displayedDownloadedBytes = sample.getDownloadedBytes();
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot expandTotalBytes(long j) {
        this.totalBytes = Math.max(this.totalBytes, RangesKt.coerceAtLeast(j, 0L));
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot beginLauncher() {
        ArchiveTransferProgressTracker.reset$default(this.archiveProgressTracker, 0L, 1, null);
        this.launcherAttempt = 0;
        this.launcherAttemptPositionBytes = 0L;
        resetTransfer(0L);
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot onLauncherProgress(LauncherApkProgress progress) {
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Long totalBytes = progress.getTotalBytes();
        if (totalBytes != null) {
            if (totalBytes.longValue() <= 0) {
                totalBytes = null;
            }
            if (totalBytes != null) {
                this.totalBytes = totalBytes.longValue();
            }
        }
        if (progress.getAttempt() != this.launcherAttempt) {
            this.launcherAttempt = progress.getAttempt();
            this.launcherAttemptPositionBytes = progress.getDownloadedBytes();
        } else {
            TransferSpeedMeter transferSpeedMeter = this.speedMeter;
            if (transferSpeedMeter != null) {
                transferSpeedMeter.addBytes(RangesKt.coerceAtLeast(progress.getDownloadedBytes() - this.launcherAttemptPositionBytes, 0L));
            }
            this.launcherAttemptPositionBytes = progress.getDownloadedBytes();
        }
        if (this.totalBytes > 0) {
            coerceAtLeast = RangesKt.coerceIn(progress.getDownloadedBytes(), 0L, this.totalBytes);
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast(progress.getDownloadedBytes(), 0L);
        }
        this.downloadedBytes = coerceAtLeast;
        this.displayedDownloadedBytes = Math.max(this.displayedDownloadedBytes, coerceAtLeast);
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot complete(long j) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        this.totalBytes = coerceAtLeast;
        this.downloadedBytes = coerceAtLeast;
        this.displayedDownloadedBytes = coerceAtLeast;
        return snapshot();
    }

    public final UpdateTransferProgressSnapshot snapshot() {
        TransferSpeedMeter transferSpeedMeter = this.speedMeter;
        long j = this.totalBytes;
        long j2 = this.downloadedBytes;
        long j3 = this.displayedDownloadedBytes;
        String speedLabel = transferSpeedMeter != null ? transferSpeedMeter.speedLabel() : null;
        if (speedLabel == null) {
            speedLabel = "";
        }
        return new UpdateTransferProgressSnapshot(j, j2, j3, speedLabel, transferSpeedMeter != null ? transferSpeedMeter.estimatedRemainingMillis(RangesKt.coerceAtLeast(this.totalBytes - this.downloadedBytes, 0L)) : null);
    }

    private final void resetTransfer(long j) {
        this.totalBytes = RangesKt.coerceAtLeast(j, 0L);
        this.downloadedBytes = 0L;
        this.displayedDownloadedBytes = 0L;
        this.speedMeter = this.speedMeterFactory.invoke();
    }
}
