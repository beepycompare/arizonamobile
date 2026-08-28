package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateSessionState.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003Ja\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0014\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\tHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0011\u0010#\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b#\u0010\u0018Ê\u0001\f\b2\u0012\b\b3\u0012\u0004\b\u0003\u0010\u0000¨\u00061"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "bootstrapPending", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "requiresFinalization", "", "server", "", "startupGuard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "storageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "plannedArchiveDownloadBytesByPackage", "", "", "<init>", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;ZLjava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;Ljava/util/Map;)V", "getPlan", "()Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "getBootstrapPending", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "getRequiresFinalization", "()Z", "getServer", "()Ljava/lang/String;", "getStartupGuard", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "getStorageRequirements", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "getPlannedArchiveDownloadBytesByPackage", "()Ljava/util/Map;", "hasPendingWork", "getHasPendingWork", "isFinalizationOnly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateSessionSnapshot {
    public static final int $stable = (ArchiveStorageRequirementsSnapshot.$stable | ArchiveBootstrapPending.$stable) | ArchiveUpdatePlan.$stable;
    private final ArchiveBootstrapPending bootstrapPending;
    private final ArchiveUpdatePlan plan;
    private final Map<String, Long> plannedArchiveDownloadBytesByPackage;
    private final boolean requiresFinalization;
    private final String server;
    private final ArchiveStartupGuard startupGuard;
    private final ArchiveStorageRequirementsSnapshot storageRequirements;

    public static /* synthetic */ ArchiveUpdateSessionSnapshot copy$default(ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot, ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard archiveStartupGuard, ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot, Map map, int i, Object obj) {
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
        Map<String, Long> map2 = map;
        if ((i & 64) != 0) {
            map2 = archiveUpdateSessionSnapshot.plannedArchiveDownloadBytesByPackage;
        }
        ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot2 = archiveStorageRequirementsSnapshot;
        Map map3 = map2;
        ArchiveStartupGuard archiveStartupGuard2 = archiveStartupGuard;
        boolean z2 = z;
        return archiveUpdateSessionSnapshot.copy(archiveUpdatePlan, archiveBootstrapPending, z2, str, archiveStartupGuard2, archiveStorageRequirementsSnapshot2, map3);
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

    public final Map<String, Long> component7() {
        return this.plannedArchiveDownloadBytesByPackage;
    }

    public final ArchiveUpdateSessionSnapshot copy(ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard startupGuard, ArchiveStorageRequirementsSnapshot storageRequirements, Map<String, Long> plannedArchiveDownloadBytesByPackage) {
        Intrinsics.checkNotNullParameter(startupGuard, "startupGuard");
        Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
        Intrinsics.checkNotNullParameter(plannedArchiveDownloadBytesByPackage, "plannedArchiveDownloadBytesByPackage");
        return new ArchiveUpdateSessionSnapshot(archiveUpdatePlan, archiveBootstrapPending, z, str, startupGuard, storageRequirements, plannedArchiveDownloadBytesByPackage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveUpdateSessionSnapshot) {
            ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot = (ArchiveUpdateSessionSnapshot) obj;
            return Intrinsics.areEqual(this.plan, archiveUpdateSessionSnapshot.plan) && Intrinsics.areEqual(this.bootstrapPending, archiveUpdateSessionSnapshot.bootstrapPending) && this.requiresFinalization == archiveUpdateSessionSnapshot.requiresFinalization && Intrinsics.areEqual(this.server, archiveUpdateSessionSnapshot.server) && this.startupGuard == archiveUpdateSessionSnapshot.startupGuard && Intrinsics.areEqual(this.storageRequirements, archiveUpdateSessionSnapshot.storageRequirements) && Intrinsics.areEqual(this.plannedArchiveDownloadBytesByPackage, archiveUpdateSessionSnapshot.plannedArchiveDownloadBytesByPackage);
        }
        return false;
    }

    public int hashCode() {
        ArchiveUpdatePlan archiveUpdatePlan = this.plan;
        int hashCode = (archiveUpdatePlan == null ? 0 : archiveUpdatePlan.hashCode()) * 31;
        ArchiveBootstrapPending archiveBootstrapPending = this.bootstrapPending;
        int hashCode2 = (((hashCode + (archiveBootstrapPending == null ? 0 : archiveBootstrapPending.hashCode())) * 31) + Boolean.hashCode(this.requiresFinalization)) * 31;
        String str = this.server;
        return ((((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.startupGuard.hashCode()) * 31) + this.storageRequirements.hashCode()) * 31) + this.plannedArchiveDownloadBytesByPackage.hashCode();
    }

    public String toString() {
        ArchiveUpdatePlan archiveUpdatePlan = this.plan;
        ArchiveBootstrapPending archiveBootstrapPending = this.bootstrapPending;
        boolean z = this.requiresFinalization;
        String str = this.server;
        ArchiveStartupGuard archiveStartupGuard = this.startupGuard;
        ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot = this.storageRequirements;
        return "ArchiveUpdateSessionSnapshot(plan=" + archiveUpdatePlan + ", bootstrapPending=" + archiveBootstrapPending + ", requiresFinalization=" + z + ", server=" + str + ", startupGuard=" + archiveStartupGuard + ", storageRequirements=" + archiveStorageRequirementsSnapshot + ", plannedArchiveDownloadBytesByPackage=" + this.plannedArchiveDownloadBytesByPackage + ")";
    }

    public ArchiveUpdateSessionSnapshot(ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard startupGuard, ArchiveStorageRequirementsSnapshot storageRequirements, Map<String, Long> plannedArchiveDownloadBytesByPackage) {
        Intrinsics.checkNotNullParameter(startupGuard, "startupGuard");
        Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
        Intrinsics.checkNotNullParameter(plannedArchiveDownloadBytesByPackage, "plannedArchiveDownloadBytesByPackage");
        this.plan = archiveUpdatePlan;
        this.bootstrapPending = archiveBootstrapPending;
        this.requiresFinalization = z;
        this.server = str;
        this.startupGuard = startupGuard;
        this.storageRequirements = storageRequirements;
        this.plannedArchiveDownloadBytesByPackage = plannedArchiveDownloadBytesByPackage;
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

    public /* synthetic */ ArchiveUpdateSessionSnapshot(ArchiveUpdatePlan archiveUpdatePlan, ArchiveBootstrapPending archiveBootstrapPending, boolean z, String str, ArchiveStartupGuard archiveStartupGuard, ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveUpdatePlan, archiveBootstrapPending, z, str, archiveStartupGuard, archiveStorageRequirementsSnapshot, (i & 64) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Long> getPlannedArchiveDownloadBytesByPackage() {
        return this.plannedArchiveDownloadBytesByPackage;
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
