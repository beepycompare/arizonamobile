package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchiveStateValidation;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneOwnershipHandoff.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ<\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u0015JF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J|\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J&\u0010%\u001a\u00020&2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0002J$\u0010*\u001a\u00020&2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u0002J\u0018\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\u000bH\u0002J.\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00072\b\u0010.\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u00101\u001a\u00020#H\u0002J&\u00102\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u00103\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000bH\u0002J$\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00068"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneOwnershipHandoff;", "", "<init>", "()V", "evaluate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneHandoffDecision;", "baseDesired", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveOwnedFileProof;", "viceDesired", "baseState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "viceState", "persist", "", "baseStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "viceStore", "transfers", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneTransfer;", "nowEpochMs", "", "findTransfers", "baseLive", "viceLive", "transfersFor", "winningDesired", "", "", "winningLive", "losingLive", "losingDesired", "winningPackageIds", "", "fromScope", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "toScope", "losingPackageKeepsOtherFiles", "", "", "transferredPath", "packageId", "wouldEmptyLoser", "live", "releases", "liveCommittedProofsOrNull", RemoteConfigConstants.ResponseFieldKey.STATE, "virtualOwnership", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "scope", "release", "claim", "persistBarrier", "store", "uniqueByExactPath", "proofs", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneOwnershipHandoff {
    public static final int $stable = 0;
    public static final ArchiveCrossLaneOwnershipHandoff INSTANCE = new ArchiveCrossLaneOwnershipHandoff();

    private ArchiveCrossLaneOwnershipHandoff() {
    }

    public final ArchiveCrossLaneHandoffDecision evaluate(List<ArchiveOwnedFileProof> baseDesired, List<ArchiveOwnedFileProof> viceDesired, ArchiveUpdaterState archiveUpdaterState, ArchiveUpdaterState archiveUpdaterState2) {
        List<ArchiveCrossLaneTransfer> findTransfers;
        Intrinsics.checkNotNullParameter(baseDesired, "baseDesired");
        Intrinsics.checkNotNullParameter(viceDesired, "viceDesired");
        List<ArchiveOwnedFileProof> liveCommittedProofsOrNull = archiveUpdaterState != null ? liveCommittedProofsOrNull(archiveUpdaterState) : null;
        List<ArchiveOwnedFileProof> liveCommittedProofsOrNull2 = archiveUpdaterState2 != null ? liveCommittedProofsOrNull(archiveUpdaterState2) : null;
        if ((archiveUpdaterState == null || liveCommittedProofsOrNull != null) && (archiveUpdaterState2 == null || liveCommittedProofsOrNull2 != null)) {
            if (liveCommittedProofsOrNull == null) {
                liveCommittedProofsOrNull = CollectionsKt.emptyList();
            }
            if (liveCommittedProofsOrNull2 == null) {
                liveCommittedProofsOrNull2 = CollectionsKt.emptyList();
            }
            findTransfers = findTransfers(baseDesired, viceDesired, liveCommittedProofsOrNull, liveCommittedProofsOrNull2);
        } else {
            findTransfers = CollectionsKt.emptyList();
        }
        List<ArchiveContentCollision> collisions = ArchiveContentCollisionGuard.INSTANCE.validate(ArchiveLaneOwnership.INSTANCE.fromProofs(baseDesired), ArchiveLaneOwnership.INSTANCE.fromProofs(viceDesired), virtualOwnership(archiveUpdaterState, findTransfers, ArchiveUpdaterStorageScope.BASE), virtualOwnership(archiveUpdaterState2, findTransfers, ArchiveUpdaterStorageScope.VICE)).getCollisions();
        if (!collisions.isEmpty()) {
            findTransfers = CollectionsKt.emptyList();
        }
        return new ArchiveCrossLaneHandoffDecision(findTransfers, collisions);
    }

    public final void persist(DurableArchiveStateStore baseStore, DurableArchiveStateStore viceStore, ArchiveUpdaterState baseState, ArchiveUpdaterState viceState, List<ArchiveCrossLaneTransfer> transfers, long j) {
        Intrinsics.checkNotNullParameter(baseStore, "baseStore");
        Intrinsics.checkNotNullParameter(viceStore, "viceStore");
        Intrinsics.checkNotNullParameter(baseState, "baseState");
        Intrinsics.checkNotNullParameter(viceState, "viceState");
        Intrinsics.checkNotNullParameter(transfers, "transfers");
        if (transfers.isEmpty()) {
            return;
        }
        List<ArchiveCrossLaneTransfer> list = transfers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ArchiveCrossLaneTransfer) obj).getFromScope() == ArchiveUpdaterStorageScope.VICE) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (((ArchiveCrossLaneTransfer) obj2).getFromScope() == ArchiveUpdaterStorageScope.BASE) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list) {
            if (((ArchiveCrossLaneTransfer) obj3).getToScope() == ArchiveUpdaterStorageScope.BASE) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList();
        for (Object obj4 : list) {
            if (((ArchiveCrossLaneTransfer) obj4).getToScope() == ArchiveUpdaterStorageScope.VICE) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = arrayList7;
        if (!arrayList2.isEmpty()) {
            viceState = release(viceState, arrayList2, j);
            persistBarrier(viceStore, viceState);
        }
        if (!arrayList4.isEmpty()) {
            baseState = release(baseState, arrayList4, j);
            persistBarrier(baseStore, baseState);
        }
        if (!arrayList6.isEmpty()) {
            persistBarrier(baseStore, claim(baseState, arrayList6, j));
        }
        if (arrayList8.isEmpty()) {
            return;
        }
        persistBarrier(viceStore, claim(viceState, arrayList8, j));
    }

    private final List<ArchiveCrossLaneTransfer> findTransfers(List<ArchiveOwnedFileProof> list, List<ArchiveOwnedFileProof> list2, List<ArchiveOwnedFileProof> list3, List<ArchiveOwnedFileProof> list4) {
        Map<String, ArchiveOwnedFileProof> uniqueByExactPath;
        Map<String, ArchiveOwnedFileProof> uniqueByExactPath2;
        Map<String, ArchiveOwnedFileProof> uniqueByExactPath3;
        Map<String, ArchiveOwnedFileProof> uniqueByExactPath4 = uniqueByExactPath(list);
        if (uniqueByExactPath4 != null && (uniqueByExactPath = uniqueByExactPath(list2)) != null && (uniqueByExactPath2 = uniqueByExactPath(list3)) != null && (uniqueByExactPath3 = uniqueByExactPath(list4)) != null) {
            List<ArchiveOwnedFileProof> list5 = list3;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
            for (ArchiveOwnedFileProof archiveOwnedFileProof : list5) {
                arrayList.add(archiveOwnedFileProof.getPackageId());
            }
            Set<String> set = CollectionsKt.toSet(arrayList);
            List<ArchiveOwnedFileProof> list6 = list4;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            for (ArchiveOwnedFileProof archiveOwnedFileProof2 : list6) {
                arrayList2.add(archiveOwnedFileProof2.getPackageId());
            }
            Set<String> set2 = CollectionsKt.toSet(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList3;
            CollectionsKt.addAll(arrayList4, transfersFor(uniqueByExactPath4, uniqueByExactPath2, uniqueByExactPath3, uniqueByExactPath, set, ArchiveUpdaterStorageScope.VICE, ArchiveUpdaterStorageScope.BASE));
            CollectionsKt.addAll(arrayList4, transfersFor(uniqueByExactPath, uniqueByExactPath3, uniqueByExactPath2, uniqueByExactPath4, set2, ArchiveUpdaterStorageScope.BASE, ArchiveUpdaterStorageScope.VICE));
            if (arrayList3.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList<ArchiveCrossLaneTransfer> arrayList5 = arrayList3;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer : arrayList5) {
                arrayList6.add(archiveCrossLaneTransfer.getRelativePath());
            }
            ArrayList arrayList7 = arrayList6;
            if (arrayList7.size() != CollectionsKt.toSet(arrayList7).size()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList8 = new ArrayList();
            for (Object obj : arrayList5) {
                if (((ArchiveCrossLaneTransfer) obj).getFromScope() == ArchiveUpdaterStorageScope.BASE) {
                    arrayList8.add(obj);
                }
            }
            if (!wouldEmptyLoser(list3, arrayList8)) {
                ArrayList arrayList9 = new ArrayList();
                for (Object obj2 : arrayList5) {
                    if (((ArchiveCrossLaneTransfer) obj2).getFromScope() == ArchiveUpdaterStorageScope.VICE) {
                        arrayList9.add(obj2);
                    }
                }
                if (!wouldEmptyLoser(list4, arrayList9)) {
                    return arrayList3;
                }
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.emptyList();
    }

    private final List<ArchiveCrossLaneTransfer> transfersFor(Map<String, ArchiveOwnedFileProof> map, Map<String, ArchiveOwnedFileProof> map2, Map<String, ArchiveOwnedFileProof> map3, Map<String, ArchiveOwnedFileProof> map4, Set<String> set, ArchiveUpdaterStorageScope archiveUpdaterStorageScope, ArchiveUpdaterStorageScope archiveUpdaterStorageScope2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ArchiveOwnedFileProof> entry : map.entrySet()) {
            String key = entry.getKey();
            ArchiveOwnedFileProof value = entry.getValue();
            ArchiveOwnedFileProof archiveOwnedFileProof = map3.get(key);
            if (archiveOwnedFileProof != null && !map2.containsKey(key) && !map4.containsKey(key) && set.contains(value.getPackageId()) && archiveOwnedFileProof.getSize() == value.getSize() && archiveOwnedFileProof.getCrc32() == value.getCrc32() && losingPackageKeepsOtherFiles(map3.values(), key, archiveOwnedFileProof.getPackageId())) {
                arrayList.add(new ArchiveCrossLaneTransfer(archiveUpdaterStorageScope, archiveUpdaterStorageScope2, archiveOwnedFileProof.getPackageId(), value.getPackageId(), key, value.getSize(), value.getCrc32(), archiveOwnedFileProof.getMd5()));
            }
        }
        return arrayList;
    }

    private final boolean wouldEmptyLoser(List<ArchiveOwnedFileProof> list, List<ArchiveCrossLaneTransfer> list2) {
        if (list2.isEmpty()) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list2) {
            String fromPackageId = ((ArchiveCrossLaneTransfer) obj).getFromPackageId();
            Object obj2 = linkedHashMap.get(fromPackageId);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(fromPackageId, obj2);
            }
            ((List) obj2).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            List<ArchiveCrossLaneTransfer> list3 = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer : list3) {
                arrayList.add(archiveCrossLaneTransfer.getRelativePath());
            }
            linkedHashMap2.put(key, CollectionsKt.toSet(arrayList));
        }
        if (linkedHashMap2.isEmpty()) {
            return false;
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str = (String) entry2.getKey();
            Set set = (Set) entry2.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : list) {
                if (Intrinsics.areEqual(((ArchiveOwnedFileProof) obj3).getPackageId(), str)) {
                    arrayList2.add(obj3);
                }
            }
            ArrayList<ArchiveOwnedFileProof> arrayList3 = arrayList2;
            if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
                return true;
            }
            for (ArchiveOwnedFileProof archiveOwnedFileProof : arrayList3) {
                if (!set.contains(archiveOwnedFileProof.getRelativePath())) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    private final List<ArchiveOwnedFileProof> liveCommittedProofsOrNull(ArchiveUpdaterState archiveUpdaterState) {
        if (archiveUpdaterState.isInstallReady()) {
            List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
            for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
                if (!archivePackageJournalEntry.isReady() || !archivePackageJournalEntry.getPreviousFiles().isEmpty()) {
                    return null;
                }
                List<ArchivePackageFileRecord> files = archivePackageJournalEntry.getFiles();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(files, 10));
                for (ArchivePackageFileRecord archivePackageFileRecord : files) {
                    arrayList2.add(new ArchiveOwnedFileProof(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath(), archivePackageFileRecord.getSize(), archivePackageFileRecord.getCrc32(), archivePackageFileRecord.getMd5()));
                }
                arrayList.add(arrayList2);
            }
            return CollectionsKt.flatten(arrayList);
        }
        return null;
    }

    private final List<ArchiveOwnedPath> virtualOwnership(ArchiveUpdaterState archiveUpdaterState, List<ArchiveCrossLaneTransfer> list, ArchiveUpdaterStorageScope archiveUpdaterStorageScope) {
        List<ArchiveCrossLaneTransfer> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((ArchiveCrossLaneTransfer) obj).getFromScope() == archiveUpdaterStorageScope) {
                arrayList.add(obj);
            }
        }
        ArrayList<ArchiveCrossLaneTransfer> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer : arrayList2) {
            String relativePath = archiveCrossLaneTransfer.getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList3.add(lowerCase);
        }
        Set set = CollectionsKt.toSet(arrayList3);
        List<ArchiveOwnedPath> fromState = archiveUpdaterState != null ? ArchiveLaneOwnership.INSTANCE.fromState(archiveUpdaterState) : null;
        if (fromState == null) {
            fromState = CollectionsKt.emptyList();
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : fromState) {
            String relativePath2 = ((ArchiveOwnedPath) obj2).getRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = relativePath2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!set.contains(lowerCase2)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : list2) {
            if (((ArchiveCrossLaneTransfer) obj3).getToScope() == archiveUpdaterStorageScope) {
                arrayList6.add(obj3);
            }
        }
        ArrayList<ArchiveCrossLaneTransfer> arrayList7 = arrayList6;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer2 : arrayList7) {
            arrayList8.add(new ArchiveOwnedPath(archiveCrossLaneTransfer2.getToPackageId(), archiveCrossLaneTransfer2.getRelativePath()));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList9 = new ArrayList();
        for (Object obj4 : CollectionsKt.plus((Collection) arrayList5, (Iterable) arrayList8)) {
            String relativePath3 = ((ArchiveOwnedPath) obj4).getRelativePath();
            Locale ROOT3 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT3, "ROOT");
            String lowerCase3 = relativePath3.toLowerCase(ROOT3);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (hashSet.add(lowerCase3)) {
                arrayList9.add(obj4);
            }
        }
        return arrayList9;
    }

    private final ArchiveUpdaterState release(ArchiveUpdaterState archiveUpdaterState, List<ArchiveCrossLaneTransfer> list, long j) {
        List<ArchiveCrossLaneTransfer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer : list2) {
            String relativePath = archiveCrossLaneTransfer.getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : archivePackageJournalEntry.getFiles()) {
                String relativePath2 = ((ArchivePackageFileRecord) obj).getRelativePath();
                Locale ROOT2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                String lowerCase2 = relativePath2.toLowerCase(ROOT2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (!set.contains(lowerCase2)) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : archivePackageJournalEntry.getDesiredFiles()) {
                String relativePath3 = ((ArchivePackageFileRecord) obj2).getRelativePath();
                Locale ROOT3 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT3, "ROOT");
                String lowerCase3 = relativePath3.toLowerCase(ROOT3);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (!set.contains(lowerCase3)) {
                    arrayList5.add(obj2);
                }
            }
            arrayList2.add(ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, null, 0L, null, arrayList4, arrayList5, null, 0L, null, 463, null));
        }
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        for (Object obj3 : archiveUpdaterState.getPendingRetirements()) {
            String relativePath4 = ((ArchiveFileRetirementRecord) obj3).getRelativePath();
            Locale ROOT4 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT4, "ROOT");
            String lowerCase4 = relativePath4.toLowerCase(ROOT4);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (!set.contains(lowerCase4)) {
                arrayList7.add(obj3);
            }
        }
        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(archiveUpdaterState, 0, null, null, 0, null, arrayList6, arrayList7, false, j, 159, null);
        ArchiveStateValidation.INSTANCE.requireValidState(copy$default);
        return copy$default;
    }

    private final ArchiveUpdaterState claim(ArchiveUpdaterState archiveUpdaterState, List<ArchiveCrossLaneTransfer> list, long j) {
        List plus;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String toPackageId = ((ArchiveCrossLaneTransfer) obj).getToPackageId();
            Object obj2 = linkedHashMap.get(toPackageId);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(toPackageId, obj2);
            }
            ((List) obj2).add(obj);
        }
        List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            List list2 = (List) linkedHashMap.get(archivePackageJournalEntry.getPackageId());
            if (list2 == null) {
                list2 = CollectionsKt.emptyList();
            }
            if (!list2.isEmpty()) {
                List<ArchiveCrossLaneTransfer> list3 = list2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (ArchiveCrossLaneTransfer archiveCrossLaneTransfer : list3) {
                    arrayList2.add(new ArchivePackageFileRecord(archiveCrossLaneTransfer.getRelativePath(), archiveCrossLaneTransfer.getSize(), archiveCrossLaneTransfer.getCrc32(), archiveCrossLaneTransfer.getMd5()));
                }
                ArrayList arrayList3 = arrayList2;
                List plus2 = CollectionsKt.plus((Collection) archivePackageJournalEntry.getFiles(), (Iterable) arrayList3);
                if (archivePackageJournalEntry.getDesiredFiles().isEmpty()) {
                    plus = CollectionsKt.emptyList();
                } else {
                    plus = CollectionsKt.plus((Collection) archivePackageJournalEntry.getDesiredFiles(), (Iterable) arrayList3);
                }
                archivePackageJournalEntry = ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, null, 0L, null, plus2, plus, null, 0L, null, 463, null);
            }
            arrayList.add(archivePackageJournalEntry);
        }
        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(archiveUpdaterState, 0, null, null, 0, null, arrayList, null, false, j, 223, null);
        ArchiveStateValidation.INSTANCE.requireValidState(copy$default);
        return copy$default;
    }

    private final void persistBarrier(DurableArchiveStateStore durableArchiveStateStore, ArchiveUpdaterState archiveUpdaterState) {
        durableArchiveStateStore.save(archiveUpdaterState);
        durableArchiveStateStore.save(archiveUpdaterState);
    }

    private final Map<String, ArchiveOwnedFileProof> uniqueByExactPath(List<ArchiveOwnedFileProof> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (ArchiveOwnedFileProof archiveOwnedFileProof : list) {
            if (linkedHashMap.put(archiveOwnedFileProof.getRelativePath(), archiveOwnedFileProof) != null) {
                return null;
            }
        }
        return linkedHashMap;
    }

    private final boolean losingPackageKeepsOtherFiles(Iterable<ArchiveOwnedFileProof> iterable, String str, String str2) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (ArchiveOwnedFileProof archiveOwnedFileProof : iterable) {
            if (Intrinsics.areEqual(archiveOwnedFileProof.getPackageId(), str2) && !Intrinsics.areEqual(archiveOwnedFileProof.getRelativePath(), str)) {
                return true;
            }
        }
        return false;
    }
}
