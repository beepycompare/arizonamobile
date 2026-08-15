package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveStorageEstimator.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJF\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fJ\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageEstimator;", "", "<init>", "()V", "downloadBytes", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "requiredFreeSpaceBytes", "stagingBytesByPackage", "", "", "archiveAllocatedBytesByPackage", "storageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirements;", "checkedSum", "values", "", "matches", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageEstimator {
    public static final int $stable = 0;
    public static final ArchiveStorageEstimator INSTANCE = new ArchiveStorageEstimator();

    /* compiled from: ArchiveStorageEstimator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchivePackagePhase.values().length];
            try {
                iArr[ArchivePackagePhase.PLANNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ArchiveStorageEstimator() {
    }

    public static /* synthetic */ long downloadBytes$default(ArchiveStorageEstimator archiveStorageEstimator, ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
        if ((i & 2) != 0) {
            archiveUpdaterState = null;
        }
        return archiveStorageEstimator.downloadBytes(archiveUpdatePlan, archiveUpdaterState);
    }

    public final long downloadBytes(ArchiveUpdatePlan plan, ArchiveUpdaterState archiveUpdaterState) {
        long archiveSize;
        Intrinsics.checkNotNullParameter(plan, "plan");
        if (plan.getType() == ArchivePlanType.SKIP) {
            return 0L;
        }
        List<ArchivePackage> packages = plan.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackage archivePackage : packages) {
            ArchivePackageJournalEntry packageById = archiveUpdaterState != null ? archiveUpdaterState.packageById(archivePackage.getId()) : null;
            if (packageById == null) {
                archiveSize = archivePackage.getArchiveSize();
            } else if (!INSTANCE.matches(packageById, archivePackage)) {
                archiveSize = archivePackage.getArchiveSize();
            } else {
                switch (WhenMappings.$EnumSwitchMapping$0[packageById.getPhase().ordinal()]) {
                    case 1:
                        archiveSize = archivePackage.getArchiveSize();
                        continue;
                    case 2:
                        archiveSize = archivePackage.getArchiveSize();
                        continue;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        archiveSize = 0;
                        continue;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(Long.valueOf(archiveSize));
        }
        return checkedSum(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long requiredFreeSpaceBytes$default(ArchiveStorageEstimator archiveStorageEstimator, ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            archiveUpdaterState = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return archiveStorageEstimator.requiredFreeSpaceBytes(archiveUpdatePlan, archiveUpdaterState, map, map2);
    }

    public final long requiredFreeSpaceBytes(ArchiveUpdatePlan plan, ArchiveUpdaterState archiveUpdaterState, Map<String, Long> stagingBytesByPackage, Map<String, Long> archiveAllocatedBytesByPackage) {
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(stagingBytesByPackage, "stagingBytesByPackage");
        Intrinsics.checkNotNullParameter(archiveAllocatedBytesByPackage, "archiveAllocatedBytesByPackage");
        return storageRequirements(plan, archiveUpdaterState, stagingBytesByPackage, archiveAllocatedBytesByPackage).getCombinedBytes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveStorageRequirements storageRequirements$default(ArchiveStorageEstimator archiveStorageEstimator, ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            archiveUpdaterState = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return archiveStorageEstimator.storageRequirements(archiveUpdatePlan, archiveUpdaterState, map, map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r3v20 */
    public final ArchiveStorageRequirements storageRequirements(ArchiveUpdatePlan plan, ArchiveUpdaterState archiveUpdaterState, Map<String, Long> stagingBytesByPackage, Map<String, Long> archiveAllocatedBytesByPackage) {
        long installedSize;
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(stagingBytesByPackage, "stagingBytesByPackage");
        Intrinsics.checkNotNullParameter(archiveAllocatedBytesByPackage, "archiveAllocatedBytesByPackage");
        if (plan.getType() == ArchivePlanType.SKIP) {
            return new ArchiveStorageRequirements(0L, 0L);
        }
        List<ArchivePackage> packages = plan.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        Iterator it = packages.iterator();
        while (true) {
            if (!it.hasNext()) {
                long checkedSum = checkedSum(arrayList);
                Iterator it2 = plan.getPackages().iterator();
                if (it2.hasNext()) {
                    ArchivePackage archivePackage = (ArchivePackage) it2.next();
                    ArchivePackageJournalEntry packageById = archiveUpdaterState != null ? archiveUpdaterState.packageById(archivePackage.getId()) : null;
                    Long l = archiveAllocatedBytesByPackage.get(archivePackage.getId());
                    long archiveSize = archivePackage.getArchiveSize() - (l != null ? RangesKt.coerceIn(l.longValue(), 0L, archivePackage.getArchiveSize()) : 0L);
                    if (packageById == null || INSTANCE.matches(packageById, archivePackage)) {
                        ArchivePackagePhase phase = packageById != null ? packageById.getPhase() : null;
                        switch (phase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
                            case -1:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                break;
                            case 0:
                            default:
                                throw new NoWhenBranchMatchedException();
                            case 7:
                            case 8:
                            case 9:
                                archiveSize = 0;
                                break;
                        }
                    }
                    Long valueOf = Long.valueOf(archiveSize);
                    while (it2.hasNext()) {
                        ArchivePackage archivePackage2 = (ArchivePackage) it2.next();
                        ArchivePackageJournalEntry packageById2 = archiveUpdaterState != null ? archiveUpdaterState.packageById(archivePackage2.getId()) : null;
                        Long l2 = archiveAllocatedBytesByPackage.get(archivePackage2.getId());
                        long archiveSize2 = archivePackage2.getArchiveSize() - (l2 != null ? RangesKt.coerceIn(l2.longValue(), 0L, archivePackage2.getArchiveSize()) : 0L);
                        if (packageById2 == null || INSTANCE.matches(packageById2, archivePackage2)) {
                            ArchivePackagePhase phase2 = packageById2 != null ? packageById2.getPhase() : null;
                            switch (phase2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[phase2.ordinal()]) {
                                case -1:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    break;
                                case 0:
                                default:
                                    throw new NoWhenBranchMatchedException();
                                case 7:
                                case 8:
                                case 9:
                                    archiveSize2 = 0;
                                    break;
                            }
                        }
                        Long valueOf2 = Long.valueOf(archiveSize2);
                        if (valueOf.compareTo(valueOf2) < 0) {
                            valueOf = valueOf2;
                        }
                    }
                    r10 = valueOf;
                }
                Long l3 = (Long) r10;
                return new ArchiveStorageRequirements(checkedSum, l3 != null ? l3.longValue() : 0L);
            }
            ArchivePackage archivePackage3 = (ArchivePackage) it.next();
            ArchivePackageJournalEntry packageById3 = archiveUpdaterState != null ? archiveUpdaterState.packageById(archivePackage3.getId()) : null;
            if (packageById3 == null || INSTANCE.matches(packageById3, archivePackage3)) {
                r10 = packageById3 != null ? packageById3.getPhase() : null;
                switch (r10 != null ? WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] : -1) {
                    case -1:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        Long l4 = stagingBytesByPackage.get(archivePackage3.getId());
                        installedSize = archivePackage3.getInstalledSize() - (l4 != null ? RangesKt.coerceIn(l4.longValue(), 0L, archivePackage3.getInstalledSize()) : 0L);
                        continue;
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 7:
                    case 8:
                    case 9:
                        installedSize = 0;
                        continue;
                }
            } else {
                installedSize = archivePackage3.getInstalledSize();
            }
            arrayList.add(Long.valueOf(installedSize));
        }
    }

    private final boolean matches(ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackage archivePackage) {
        return archivePackageJournalEntry.getArchiveSize() == archivePackage.getArchiveSize() && archivePackageJournalEntry.getArchiveCrc32() == archivePackage.getCrc32();
    }

    private final long checkedSum(Iterable<Long> iterable) {
        try {
            long j = 0;
            for (Long l : iterable) {
                j = Math.addExact(j, l.longValue());
            }
            return j;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("archive byte total overflows Long", e);
        }
    }
}
