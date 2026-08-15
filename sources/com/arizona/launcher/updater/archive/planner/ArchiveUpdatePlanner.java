package com.arizona.launcher.updater.archive.planner;

import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.updater.archive.model.ArchiveLocalState;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.model.ArchivePackageIdentity;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveUpdatePlanner.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0002J0\u0010\u0013\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J*\u0010\u001a\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0002Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlanner;", "", "<init>", "()V", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "remote", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", ImagesContract.LOCAL, "Lcom/arizona/launcher/updater/archive/model/ArchiveLocalState;", UpdateActivity.UPDATE_MODE, "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanningMode;", "sameIdentityRepairPackageIds", "", "", "isCleanSameIdentityRepairAgainstRemote", "", "repairPackageIds", "", "fullUpdate", "reason", "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanReason;", "obsoletePackageIds", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "fullPlan", "type", "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdatePlanner {
    public static final int $stable = 0;
    public static final ArchiveUpdatePlanner INSTANCE = new ArchiveUpdatePlanner();

    private ArchiveUpdatePlanner() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveUpdatePlan plan$default(ArchiveUpdatePlanner archiveUpdatePlanner, ArchiveManifest archiveManifest, ArchiveLocalState archiveLocalState, ArchivePlanningMode archivePlanningMode, Collection collection, int i, Object obj) {
        if ((i & 4) != 0) {
            archivePlanningMode = ArchivePlanningMode.NORMAL;
        }
        if ((i & 8) != 0) {
            collection = null;
        }
        return archiveUpdatePlanner.plan(archiveManifest, archiveLocalState, archivePlanningMode, collection);
    }

    public final ArchiveUpdatePlan plan(ArchiveManifest remote, ArchiveLocalState archiveLocalState, ArchivePlanningMode mode, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(mode, "mode");
        ArchivePlanReason archivePlanReason = null;
        List<ArchivePackageIdentity> packages = archiveLocalState != null ? archiveLocalState.getPackages() : null;
        if (packages == null) {
            packages = CollectionsKt.emptyList();
        }
        List<ArchivePackageIdentity> list = packages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ArchivePackageIdentity archivePackageIdentity : list) {
            arrayList.add(archivePackageIdentity.getId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<ArchivePackage> packages2 = remote.getPackages();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages2, 10));
        for (ArchivePackage archivePackage : packages2) {
            arrayList2.add(archivePackage.getId());
        }
        Set<String> minus = SetsKt.minus(set, (Iterable) CollectionsKt.toSet(arrayList2));
        if (archiveLocalState == null) {
            return fullPlan(remote, ArchivePlanType.FULL_BOOTSTRAP, ArchivePlanReason.NO_LOCAL_STATE, SetsKt.emptySet());
        }
        Set<String> set2 = collection != null ? CollectionsKt.toSet(collection) : null;
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        if (mode == ArchivePlanningMode.NORMAL && !set2.isEmpty() && isCleanSameIdentityRepairAgainstRemote(remote, archiveLocalState, set2)) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : remote.getPackages()) {
                if (set2.contains(((ArchivePackage) obj).getId())) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (!arrayList4.isEmpty()) {
                return new ArchiveUpdatePlan(ArchivePlanType.FULL_UPDATE, ArchivePlanReason.PAYLOAD_REPAIR, remote, arrayList4, SetsKt.emptySet());
            }
        }
        if (archiveLocalState.getBootstrapComplete()) {
            if (mode == ArchivePlanningMode.REPAIR) {
                return fullPlan(remote, ArchivePlanType.FULL_UPDATE, ArchivePlanReason.REPAIR_REQUESTED, minus);
            }
            if (archiveLocalState.getSchemaVersion() != remote.getSchemaVersion()) {
                return fullUpdate(remote, ArchivePlanReason.LOCAL_SCHEMA_CHANGED, minus, remote.getPackages());
            }
            List<ArchivePackageIdentity> packages3 = archiveLocalState.getPackages();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages3, 10)), 16));
            for (Object obj2 : packages3) {
                linkedHashMap.put(((ArchivePackageIdentity) obj2).getId(), obj2);
            }
            List<ArchivePackage> packages4 = remote.getPackages();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages4, 10)), 16));
            for (Object obj3 : packages4) {
                linkedHashMap2.put(((ArchivePackage) obj3).getId(), obj3);
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj4 : remote.getPackages()) {
                ArchivePackage archivePackage2 = (ArchivePackage) obj4;
                if (!Intrinsics.areEqual(linkedHashMap.get(archivePackage2.getId()), archivePackage2.getIdentity())) {
                    arrayList5.add(obj4);
                }
            }
            ArrayList arrayList6 = arrayList5;
            if (archiveLocalState.getSelectedGpu() != remote.getSelectedGpu()) {
                archivePlanReason = ArchivePlanReason.GPU_PACKAGE_SET_CHANGED;
            } else if (!Intrinsics.areEqual(linkedHashMap.keySet(), linkedHashMap2.keySet())) {
                archivePlanReason = ArchivePlanReason.PACKAGE_SET_CHANGED;
            } else if (!arrayList6.isEmpty()) {
                archivePlanReason = ArchivePlanReason.PACKAGE_IDENTITY_CHANGED;
            } else if (!Intrinsics.areEqual(archiveLocalState.getManifestVersion(), remote.getManifestVersion())) {
                archivePlanReason = ArchivePlanReason.MANIFEST_VERSION_CHANGED;
            }
            return archivePlanReason != null ? fullUpdate(remote, archivePlanReason, minus, arrayList6) : new ArchiveUpdatePlan(ArchivePlanType.SKIP, ArchivePlanReason.UP_TO_DATE, remote, CollectionsKt.emptyList(), SetsKt.emptySet());
        }
        return fullPlan(remote, ArchivePlanType.FULL_BOOTSTRAP, ArchivePlanReason.BOOTSTRAP_INCOMPLETE, minus);
    }

    private final boolean isCleanSameIdentityRepairAgainstRemote(ArchiveManifest archiveManifest, ArchiveLocalState archiveLocalState, Set<String> set) {
        if (archiveLocalState.getSchemaVersion() == archiveManifest.getSchemaVersion() && Intrinsics.areEqual(archiveLocalState.getManifestVersion(), archiveManifest.getManifestVersion()) && archiveLocalState.getSelectedGpu() == archiveManifest.getSelectedGpu()) {
            List<ArchivePackageIdentity> packages = archiveLocalState.getPackages();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
            for (Object obj : packages) {
                linkedHashMap.put(((ArchivePackageIdentity) obj).getId(), obj);
            }
            List<ArchivePackage> packages2 = archiveManifest.getPackages();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages2, 10)), 16));
            for (Object obj2 : packages2) {
                linkedHashMap2.put(((ArchivePackage) obj2).getId(), obj2);
            }
            if (Intrinsics.areEqual(linkedHashMap.keySet(), linkedHashMap2.keySet())) {
                Set<String> set2 = set;
                if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                    for (String str : set2) {
                        if (!linkedHashMap2.containsKey(str)) {
                            return false;
                        }
                    }
                }
                List<ArchivePackageIdentity> packages3 = archiveLocalState.getPackages();
                if ((packages3 instanceof Collection) && packages3.isEmpty()) {
                    return true;
                }
                for (ArchivePackageIdentity archivePackageIdentity : packages3) {
                    ArchivePackage archivePackage = (ArchivePackage) linkedHashMap2.get(archivePackageIdentity.getId());
                    if (!Intrinsics.areEqual(archivePackage != null ? archivePackage.getIdentity() : null, archivePackageIdentity)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private final ArchiveUpdatePlan fullUpdate(ArchiveManifest archiveManifest, ArchivePlanReason archivePlanReason, Set<String> set, List<ArchivePackage> list) {
        return new ArchiveUpdatePlan(ArchivePlanType.FULL_UPDATE, archivePlanReason, archiveManifest, list, set);
    }

    private final ArchiveUpdatePlan fullPlan(ArchiveManifest archiveManifest, ArchivePlanType archivePlanType, ArchivePlanReason archivePlanReason, Set<String> set) {
        return new ArchiveUpdatePlan(archivePlanType, archivePlanReason, archiveManifest, archiveManifest.getPackages(), set);
    }
}
