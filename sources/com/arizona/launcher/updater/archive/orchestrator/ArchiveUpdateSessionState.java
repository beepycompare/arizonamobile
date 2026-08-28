package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateSessionState.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0010J\u001d\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u001bJ\b\u0010(\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0000¨\u0006)"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "", "initialStartupGuard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "storageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsState;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsState;)V", "lock", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "bootstrapPending", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "requiresFinalization", "", "server", "", "startupGuard", "plannedArchiveDownloadBytesByPackage", "", "", "initializeStartupGuard", "", "guard", "invalidateForManifestRefresh", "beginMetadataEvaluation", "applyDecision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "selectedServer", "updateMirrorServer", "recordRuntimeRequirements", "downloadBytes", "requiredFreeSpaceBytes", "(JLjava/lang/Long;)V", "markRecoveryRequired", "markFinalizationRequired", "markCommitted", "snapshot", "snapshotLocked", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateSessionState {
    public static final int $stable = 8;
    private ArchiveBootstrapPending bootstrapPending;
    private final Object lock;
    private ArchiveUpdatePlan plan;
    private Map<String, Long> plannedArchiveDownloadBytesByPackage;
    private boolean requiresFinalization;
    private String server;
    private ArchiveStartupGuard startupGuard;
    private final ArchiveStorageRequirementsState storageRequirements;

    public ArchiveUpdateSessionState() {
        this(null, null, 3, null);
    }

    public ArchiveUpdateSessionState(ArchiveStartupGuard initialStartupGuard, ArchiveStorageRequirementsState storageRequirements) {
        Intrinsics.checkNotNullParameter(initialStartupGuard, "initialStartupGuard");
        Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
        this.storageRequirements = storageRequirements;
        this.lock = new Object();
        this.startupGuard = initialStartupGuard;
        this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
    }

    public /* synthetic */ ArchiveUpdateSessionState(ArchiveStartupGuard archiveStartupGuard, ArchiveStorageRequirementsState archiveStorageRequirementsState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ArchiveStartupGuard.NONE : archiveStartupGuard, (i & 2) != 0 ? new ArchiveStorageRequirementsState() : archiveStorageRequirementsState);
    }

    public final void initializeStartupGuard(ArchiveStartupGuard guard) {
        Intrinsics.checkNotNullParameter(guard, "guard");
        synchronized (this.lock) {
            this.startupGuard = guard;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidateForManifestRefresh() {
        synchronized (this.lock) {
            this.plan = null;
            this.bootstrapPending = null;
            this.requiresFinalization = false;
            this.server = null;
            this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
            this.storageRequirements.reset();
            this.startupGuard = ArchiveStartupGuard.RECOVERY_REQUIRED;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void beginMetadataEvaluation() {
        synchronized (this.lock) {
            this.storageRequirements.resetPlanned();
            this.plan = null;
            this.bootstrapPending = null;
            this.requiresFinalization = false;
            this.server = null;
            this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ArchiveUpdateSessionSnapshot applyDecision(ArchiveUpdateCheckDecision decision, String selectedServer) {
        ArchiveStartupGuard archiveStartupGuard;
        ArchiveUpdateSessionSnapshot snapshotLocked;
        Intrinsics.checkNotNullParameter(decision, "decision");
        Intrinsics.checkNotNullParameter(selectedServer, "selectedServer");
        synchronized (this.lock) {
            if (decision instanceof ArchiveUpdateCheckDecision.UseArchive) {
                this.startupGuard = ArchiveStartupGuard.NONE;
                this.plan = ((ArchiveUpdateCheckDecision.UseArchive) decision).getPlan();
                this.bootstrapPending = null;
                this.requiresFinalization = ((ArchiveUpdateCheckDecision.UseArchive) decision).getRequiresFinalization();
                this.server = selectedServer;
                this.plannedArchiveDownloadBytesByPackage = MapsKt.toMap(((ArchiveUpdateCheckDecision.UseArchive) decision).getPlannedArchiveDownloadBytesByPackage());
                this.storageRequirements.applyPlanned(((ArchiveUpdateCheckDecision.UseArchive) decision).getDownloadBytes(), ((ArchiveUpdateCheckDecision.UseArchive) decision).getRequiredFreeSpaceBytes(), ((ArchiveUpdateCheckDecision.UseArchive) decision).getStorageRequirements().getGameBytes(), ((ArchiveUpdateCheckDecision.UseArchive) decision).getStorageRequirements().getDownloadBytes());
                this.storageRequirements.resetRuntime(((ArchiveUpdateCheckDecision.UseArchive) decision).getDownloadBytes(), ((ArchiveUpdateCheckDecision.UseArchive) decision).getRequiredFreeSpaceBytes());
            } else if (decision instanceof ArchiveUpdateCheckDecision.Bootstrap) {
                this.startupGuard = ArchiveStartupGuard.NONE;
                this.plan = null;
                this.bootstrapPending = ((ArchiveUpdateCheckDecision.Bootstrap) decision).getPending();
                this.requiresFinalization = false;
                this.server = null;
                this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
                this.storageRequirements.applyPlanned(((ArchiveUpdateCheckDecision.Bootstrap) decision).getPending().getDownloadBytes(), 0L, 0L, 0L);
                this.storageRequirements.resetRuntime(((ArchiveUpdateCheckDecision.Bootstrap) decision).getPending().getDownloadBytes(), 0L);
            } else if (!(decision instanceof ArchiveUpdateCheckDecision.Block)) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (((ArchiveUpdateCheckDecision.Block) decision).getCode() != ArchiveUpdateCheckBlockCode.STATE_CORRUPT && ((ArchiveUpdateCheckDecision.Block) decision).getCode() != ArchiveUpdateCheckBlockCode.STATE_IO_FAILED) {
                    archiveStartupGuard = ArchiveStartupGuard.RECOVERY_REQUIRED;
                    this.startupGuard = archiveStartupGuard;
                    this.plan = null;
                    this.bootstrapPending = null;
                    this.requiresFinalization = false;
                    this.server = null;
                    this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
                    this.storageRequirements.reset();
                }
                archiveStartupGuard = ArchiveStartupGuard.CORRUPT_STATE;
                this.startupGuard = archiveStartupGuard;
                this.plan = null;
                this.bootstrapPending = null;
                this.requiresFinalization = false;
                this.server = null;
                this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
                this.storageRequirements.reset();
            }
            snapshotLocked = snapshotLocked();
        }
        return snapshotLocked;
    }

    public final void updateMirrorServer(String selectedServer) {
        Intrinsics.checkNotNullParameter(selectedServer, "selectedServer");
        synchronized (this.lock) {
            this.server = selectedServer;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordRuntimeRequirements(long j, Long l) {
        synchronized (this.lock) {
            this.storageRequirements.recordRuntime(j, l);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void markRecoveryRequired() {
        synchronized (this.lock) {
            this.startupGuard = ArchiveStartupGuard.RECOVERY_REQUIRED;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void markFinalizationRequired() {
        synchronized (this.lock) {
            this.startupGuard = ArchiveStartupGuard.RECOVERY_REQUIRED;
            this.requiresFinalization = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void markCommitted() {
        synchronized (this.lock) {
            this.startupGuard = ArchiveStartupGuard.NONE;
            this.plan = null;
            this.bootstrapPending = null;
            this.requiresFinalization = false;
            this.server = null;
            this.plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
            this.storageRequirements.reset();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ArchiveUpdateSessionSnapshot snapshot() {
        ArchiveUpdateSessionSnapshot snapshotLocked;
        synchronized (this.lock) {
            snapshotLocked = snapshotLocked();
        }
        return snapshotLocked;
    }

    private final ArchiveUpdateSessionSnapshot snapshotLocked() {
        return new ArchiveUpdateSessionSnapshot(this.plan, this.bootstrapPending, this.requiresFinalization, this.server, this.startupGuard, this.storageRequirements.snapshot(), this.plannedArchiveDownloadBytesByPackage);
    }
}
