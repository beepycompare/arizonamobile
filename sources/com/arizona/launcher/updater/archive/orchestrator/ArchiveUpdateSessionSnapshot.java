package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateSessionState.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JK\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0014\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\tHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0000¨\u0006+"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "bootstrapPending", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "requiresFinalization", "", "server", "", "startupGuard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "storageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "<init>", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;ZLjava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;)V", "getPlan", "()Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "getBootstrapPending", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "getRequiresFinalization", "()Z", "getServer", "()Ljava/lang/String;", "getStartupGuard", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "getStorageRequirements", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "hasPendingWork", "getHasPendingWork", "isFinalizationOnly", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateSessionSnapshot {
    public static final int $stable = (ArchiveStorageRequirementsSnapshot.$stable | ArchiveBootstrapPending.$stable) | ArchiveUpdatePlan.$stable;
    private final ArchiveBootstrapPending bootstrapPending;
    private final ArchiveUpdatePlan plan;
    private final boolean requiresFinalization;
    private final String server;
    private final ArchiveStartupGuard startupGuard;
    private final ArchiveStorageRequirementsSnapshot storageRequirements;

    public static /* synthetic */ ArchiveUpdateSessionSnapshot copy$default(ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot, ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard archiveStartupGuard, ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveUpdatePlan = archiveUpdateSessionSnapshot.plan;
        }
        if ((i & 2) != 0) {
            archiveBootstrapPending = archiveUpdateSessionSnapshot.bootstrapPending;
        }
        if ((i & 4) != 0) {
            z = archiveUpdateSessionSnapshot.requiresFinalization;
        }
        if ((i & 8) != 0) {
            str = archiveUpdateSessionSnapshot.server;
        }
        if ((i & 16) != 0) {
            archiveStartupGuard = archiveUpdateSessionSnapshot.startupGuard;
        }
        if ((i & 32) != 0) {
            archiveStorageRequirementsSnapshot = archiveUpdateSessionSnapshot.storageRequirements;
        }
        ArchiveStartupGuard archiveStartupGuard2 = archiveStartupGuard;
        ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot2 = archiveStorageRequirementsSnapshot;
        return archiveUpdateSessionSnapshot.copy(archiveUpdatePlan, archiveBootstrapPending, z, str, archiveStartupGuard2, archiveStorageRequirementsSnapshot2);
    }

    public final ArchiveUpdatePlan component1() {
        return this.plan;
    }

    public final ArchiveBootstrapPending component2() {
        return this.bootstrapPending;
    }

    public final boolean component3() {
        return this.requiresFinalization;
    }

    public final String component4() {
        return this.server;
    }

    public final ArchiveStartupGuard component5() {
        return this.startupGuard;
    }

    public final ArchiveStorageRequirementsSnapshot component6() {
        return this.storageRequirements;
    }

    public final ArchiveUpdateSessionSnapshot copy(ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard startupGuard, ArchiveStorageRequirementsSnapshot storageRequirements) {
        Intrinsics.checkNotNullParameter(startupGuard, "startupGuard");
        Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
        return new ArchiveUpdateSessionSnapshot(archiveUpdatePlan, archiveBootstrapPending, z, str, startupGuard, storageRequirements);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveUpdateSessionSnapshot) {
            ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot = (ArchiveUpdateSessionSnapshot) obj;
            return Intrinsics.areEqual(this.plan, archiveUpdateSessionSnapshot.plan) && Intrinsics.areEqual(this.bootstrapPending, archiveUpdateSessionSnapshot.bootstrapPending) && this.requiresFinalization == archiveUpdateSessionSnapshot.requiresFinalization && Intrinsics.areEqual(this.server, archiveUpdateSessionSnapshot.server) && this.startupGuard == archiveUpdateSessionSnapshot.startupGuard && Intrinsics.areEqual(this.storageRequirements, archiveUpdateSessionSnapshot.storageRequirements);
        }
        return false;
    }

    public int hashCode() {
        ArchiveUpdatePlan archiveUpdatePlan = this.plan;
        int hashCode = (archiveUpdatePlan == null ? 0 : archiveUpdatePlan.hashCode()) * 31;
        ArchiveBootstrapPending archiveBootstrapPending = this.bootstrapPending;
        int hashCode2 = (((hashCode + (archiveBootstrapPending == null ? 0 : archiveBootstrapPending.hashCode())) * 31) + Boolean.hashCode(this.requiresFinalization)) * 31;
        String str = this.server;
        return ((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.startupGuard.hashCode()) * 31) + this.storageRequirements.hashCode();
    }

    public String toString() {
        ArchiveUpdatePlan archiveUpdatePlan = this.plan;
        ArchiveBootstrapPending archiveBootstrapPending = this.bootstrapPending;
        boolean z = this.requiresFinalization;
        String str = this.server;
        ArchiveStartupGuard archiveStartupGuard = this.startupGuard;
        return "ArchiveUpdateSessionSnapshot(plan=" + archiveUpdatePlan + ", bootstrapPending=" + archiveBootstrapPending + ", requiresFinalization=" + z + ", server=" + str + ", startupGuard=" + archiveStartupGuard + ", storageRequirements=" + this.storageRequirements + ")";
    }

    public ArchiveUpdateSessionSnapshot(ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard startupGuard, ArchiveStorageRequirementsSnapshot storageRequirements) {
        Intrinsics.checkNotNullParameter(startupGuard, "startupGuard");
        Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
        this.plan = archiveUpdatePlan;
        this.bootstrapPending = archiveBootstrapPending;
        this.requiresFinalization = z;
        this.server = str;
        this.startupGuard = startupGuard;
        this.storageRequirements = storageRequirements;
    }

    public final ArchiveUpdatePlan getPlan() {
        return this.plan;
    }

    public final ArchiveBootstrapPending getBootstrapPending() {
        return this.bootstrapPending;
    }

    public final boolean getRequiresFinalization() {
        return this.requiresFinalization;
    }

    public final String getServer() {
        return this.server;
    }

    public final ArchiveStartupGuard getStartupGuard() {
        return this.startupGuard;
    }

    public final ArchiveStorageRequirementsSnapshot getStorageRequirements() {
        return this.storageRequirements;
    }

    public final boolean getHasPendingWork() {
        if (this.startupGuard == ArchiveStartupGuard.NONE && this.bootstrapPending == null) {
            ArchiveWorkDispatchPolicy archiveWorkDispatchPolicy = ArchiveWorkDispatchPolicy.INSTANCE;
            ArchiveUpdatePlan archiveUpdatePlan = this.plan;
            return archiveWorkDispatchPolicy.hasPendingWork(archiveUpdatePlan != null ? archiveUpdatePlan.getType() : null, this.requiresFinalization);
        }
        return true;
    }

    public final boolean isFinalizationOnly() {
        ArchiveUpdatePlan archiveUpdatePlan = this.plan;
        return archiveUpdatePlan != null && ArchiveWorkDispatchPolicy.INSTANCE.isFinalizationOnly(archiveUpdatePlan.getType(), this.requiresFinalization);
    }
}
