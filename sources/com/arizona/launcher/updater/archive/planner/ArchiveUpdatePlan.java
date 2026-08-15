package com.arizona.launcher.updater.archive.planner;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdatePlan.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\rHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0000¨\u0006&"}, d2 = {"Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "", "type", "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;", "reason", "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanReason;", "remoteManifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "obsoletePackageIds", "", "", "<init>", "(Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;Lcom/arizona/launcher/updater/archive/planner/ArchivePlanReason;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Ljava/util/List;Ljava/util/Set;)V", "getType", "()Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;", "getReason", "()Lcom/arizona/launcher/updater/archive/planner/ArchivePlanReason;", "getRemoteManifest", "()Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "getPackages", "()Ljava/util/List;", "getObsoletePackageIds", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdatePlan {
    public static final int $stable = ArchiveManifest.$stable;
    private final Set<String> obsoletePackageIds;
    private final List<ArchivePackage> packages;
    private final ArchivePlanReason reason;
    private final ArchiveManifest remoteManifest;
    private final ArchivePlanType type;

    public static /* synthetic */ ArchiveUpdatePlan copy$default(ArchiveUpdatePlan archiveUpdatePlan, ArchivePlanType archivePlanType, ArchivePlanReason archivePlanReason, ArchiveManifest archiveManifest, List list, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            archivePlanType = archiveUpdatePlan.type;
        }
        if ((i & 2) != 0) {
            archivePlanReason = archiveUpdatePlan.reason;
        }
        if ((i & 4) != 0) {
            archiveManifest = archiveUpdatePlan.remoteManifest;
        }
        List<ArchivePackage> list2 = list;
        if ((i & 8) != 0) {
            list2 = archiveUpdatePlan.packages;
        }
        Set<String> set2 = set;
        if ((i & 16) != 0) {
            set2 = archiveUpdatePlan.obsoletePackageIds;
        }
        Set set3 = set2;
        ArchiveManifest archiveManifest2 = archiveManifest;
        return archiveUpdatePlan.copy(archivePlanType, archivePlanReason, archiveManifest2, list2, set3);
    }

    public final ArchivePlanType component1() {
        return this.type;
    }

    public final ArchivePlanReason component2() {
        return this.reason;
    }

    public final ArchiveManifest component3() {
        return this.remoteManifest;
    }

    public final List<ArchivePackage> component4() {
        return this.packages;
    }

    public final Set<String> component5() {
        return this.obsoletePackageIds;
    }

    public final ArchiveUpdatePlan copy(ArchivePlanType type, ArchivePlanReason reason, ArchiveManifest remoteManifest, List<ArchivePackage> packages, Set<String> obsoletePackageIds) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(remoteManifest, "remoteManifest");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(obsoletePackageIds, "obsoletePackageIds");
        return new ArchiveUpdatePlan(type, reason, remoteManifest, packages, obsoletePackageIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveUpdatePlan) {
            ArchiveUpdatePlan archiveUpdatePlan = (ArchiveUpdatePlan) obj;
            return this.type == archiveUpdatePlan.type && this.reason == archiveUpdatePlan.reason && Intrinsics.areEqual(this.remoteManifest, archiveUpdatePlan.remoteManifest) && Intrinsics.areEqual(this.packages, archiveUpdatePlan.packages) && Intrinsics.areEqual(this.obsoletePackageIds, archiveUpdatePlan.obsoletePackageIds);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.reason.hashCode()) * 31) + this.remoteManifest.hashCode()) * 31) + this.packages.hashCode()) * 31) + this.obsoletePackageIds.hashCode();
    }

    public String toString() {
        ArchivePlanType archivePlanType = this.type;
        ArchivePlanReason archivePlanReason = this.reason;
        ArchiveManifest archiveManifest = this.remoteManifest;
        List<ArchivePackage> list = this.packages;
        return "ArchiveUpdatePlan(type=" + archivePlanType + ", reason=" + archivePlanReason + ", remoteManifest=" + archiveManifest + ", packages=" + list + ", obsoletePackageIds=" + this.obsoletePackageIds + ")";
    }

    public ArchiveUpdatePlan(ArchivePlanType type, ArchivePlanReason reason, ArchiveManifest remoteManifest, List<ArchivePackage> packages, Set<String> obsoletePackageIds) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(remoteManifest, "remoteManifest");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(obsoletePackageIds, "obsoletePackageIds");
        this.type = type;
        this.reason = reason;
        this.remoteManifest = remoteManifest;
        this.packages = packages;
        this.obsoletePackageIds = obsoletePackageIds;
        if (type == ArchivePlanType.SKIP && !packages.isEmpty()) {
            throw new IllegalArgumentException("SKIP plan must not contain packages".toString());
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : packages) {
            if (hashSet.add(((ArchivePackage) obj).getId())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != this.packages.size()) {
            throw new IllegalArgumentException("work packages must be a unique subset of the remote package set".toString());
        }
        List<ArchivePackage> list = this.packages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        for (ArchivePackage archivePackage : list) {
            if (!this.remoteManifest.getPackages().contains(archivePackage)) {
                throw new IllegalArgumentException("work packages must be a unique subset of the remote package set".toString());
            }
        }
    }

    public final ArchivePlanType getType() {
        return this.type;
    }

    public final ArchivePlanReason getReason() {
        return this.reason;
    }

    public final ArchiveManifest getRemoteManifest() {
        return this.remoteManifest;
    }

    public final List<ArchivePackage> getPackages() {
        return this.packages;
    }

    public final Set<String> getObsoletePackageIds() {
        return this.obsoletePackageIds;
    }
}
