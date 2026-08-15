package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.Unit;
/* compiled from: ArchiveStorageRequirementsState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\rJ\u001d\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsState;", "", "<init>", "()V", "lock", "plannedDownloadBytes", "", "plannedRequiredFreeSpaceBytes", "plannedGameStorageBytes", "plannedDownloadStorageBytes", "runtimeDownloadBytes", "runtimeRequiredFreeSpaceBytes", "applyPlanned", "", "downloadBytes", "requiredFreeSpaceBytes", "gameStorageBytes", "downloadStorageBytes", "resetPlanned", "recordRuntime", "(JLjava/lang/Long;)V", "resetRuntime", "reset", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageRequirementsState {
    public static final int $stable = 8;
    private final Object lock = new Object();
    private long plannedDownloadBytes;
    private long plannedDownloadStorageBytes;
    private long plannedGameStorageBytes;
    private long plannedRequiredFreeSpaceBytes;
    private long runtimeDownloadBytes;
    private long runtimeRequiredFreeSpaceBytes;

    public final void applyPlanned(long j, long j2, long j3, long j4) {
        synchronized (this.lock) {
            this.plannedDownloadBytes = j;
            this.plannedRequiredFreeSpaceBytes = j2;
            this.plannedGameStorageBytes = j3;
            this.plannedDownloadStorageBytes = j4;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resetPlanned() {
        synchronized (this.lock) {
            this.plannedDownloadBytes = 0L;
            this.plannedRequiredFreeSpaceBytes = 0L;
            this.plannedGameStorageBytes = 0L;
            this.plannedDownloadStorageBytes = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordRuntime(long j, Long l) {
        synchronized (this.lock) {
            this.runtimeDownloadBytes = Math.max(this.runtimeDownloadBytes, j);
            if (l != null) {
                this.runtimeRequiredFreeSpaceBytes = Math.max(this.runtimeRequiredFreeSpaceBytes, l.longValue());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void resetRuntime$default(ArchiveStorageRequirementsState archiveStorageRequirementsState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        archiveStorageRequirementsState.resetRuntime(j, j2);
    }

    public final void resetRuntime(long j, long j2) {
        synchronized (this.lock) {
            this.runtimeDownloadBytes = j;
            this.runtimeRequiredFreeSpaceBytes = j2;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void reset() {
        synchronized (this.lock) {
            this.plannedDownloadBytes = 0L;
            this.plannedRequiredFreeSpaceBytes = 0L;
            this.plannedGameStorageBytes = 0L;
            this.plannedDownloadStorageBytes = 0L;
            this.runtimeDownloadBytes = 0L;
            this.runtimeRequiredFreeSpaceBytes = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ArchiveStorageRequirementsSnapshot snapshot() {
        ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot;
        synchronized (this.lock) {
            archiveStorageRequirementsSnapshot = new ArchiveStorageRequirementsSnapshot(Math.max(this.plannedDownloadBytes, this.runtimeDownloadBytes), Math.max(this.plannedRequiredFreeSpaceBytes, this.runtimeRequiredFreeSpaceBytes), this.plannedGameStorageBytes, this.plannedDownloadStorageBytes);
        }
        return archiveStorageRequirementsSnapshot;
    }
}
