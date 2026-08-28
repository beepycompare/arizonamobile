package com.arizona.launcher.updater.archive.orchestrator;

import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.model.ArchiveResolvedZipFileMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveResolvedZipIndexMetadata;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.range.ArchiveEntryChangePlan;
import com.arizona.launcher.updater.archive.range.ArchiveSelectiveEntryDiff;
import com.arizona.launcher.updater.archive.range.ArchiveSelectiveUpdatePolicy;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchivePhaseTransitions;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectiveDownloadEstimator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ)\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J;\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J>\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\"\u0018\u00010\u0005\"\u0004\b\u0000\u0010\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0\u001a2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u00060$H\u0002Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0002¨\u0006&"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator;", "", "<init>", "()V", "plannedNetworkBytesByPackage", "", "", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "estimateNetworkBytes", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", DiskLruCache.JOURNAL_FILE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "estimateNetworkBytes$app", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Lcom/arizona/launcher/updater/archive/model/ArchivePackage;Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;)Ljava/lang/Long;", "projectedJournal", UpdateServiceContract.BundleKey.CURRENT, "projectedJournal$app", "isRebasedPlannedJournal", "", "estimateFromObservedIndex", "desired", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "toFetch", "layout", "Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "(Lcom/arizona/launcher/updater/archive/model/ArchivePackage;Ljava/util/List;Ljava/util/List;Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;)Ljava/lang/Long;", "uniqueByPath", OriginalTzArchiveManifestParser.FILES_ROOT, ExifInterface.GPS_DIRECTION_TRUE, "path", "Lkotlin/Function1;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectiveDownloadEstimator {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long ZIP_LOCAL_HEADER_FIXED_BYTES = 30;

    public final Map<String, Long> plannedNetworkBytesByPackage(ArchiveUpdatePlan plan, ArchiveUpdaterState archiveUpdaterState) {
        Intrinsics.checkNotNullParameter(plan, "plan");
        if (plan.getType() != ArchivePlanType.FULL_UPDATE) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ArchivePackage archivePackage : plan.getPackages()) {
            Long l = null;
            ArchivePackageJournalEntry projectedJournal$app = projectedJournal$app(archiveUpdaterState != null ? archiveUpdaterState.packageById(archivePackage.getId()) : null, archivePackage);
            if (projectedJournal$app != null) {
                try {
                    l = estimateNetworkBytes$app(plan, archivePackage, projectedJournal$app);
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused) {
                }
                if (l != null) {
                    long longValue = l.longValue();
                    if (1 <= longValue && longValue < archivePackage.getArchiveSize()) {
                        linkedHashMap.put(archivePackage.getId(), Long.valueOf(longValue));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final Long estimateNetworkBytes$app(ArchiveUpdatePlan plan, ArchivePackage archivePackage, ArchivePackageJournalEntry journal) {
        ArchiveResolvedZipIndexMetadata resolvedZipIndexMetadata;
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        Intrinsics.checkNotNullParameter(journal, "journal");
        if (ArchiveSelectiveUpdatePolicy.INSTANCE.isCandidate(plan, journal, archivePackage) && (resolvedZipIndexMetadata = archivePackage.getResolvedZipIndexMetadata()) != null) {
            ArchiveEntryChangePlan plan2 = ArchiveSelectiveEntryDiff.INSTANCE.plan(journal.getPreviousFiles(), journal.getDesiredFiles());
            if (plan2.getReusable().isEmpty() || plan2.getToFetch().isEmpty()) {
                return null;
            }
            return estimateFromObservedIndex(archivePackage, journal.getDesiredFiles(), plan2.getToFetch(), resolvedZipIndexMetadata);
        }
        return null;
    }

    public final ArchivePackageJournalEntry projectedJournal$app(ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        if (archivePackageJournalEntry == null) {
            return null;
        }
        List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
        if (entries == null) {
            entries = CollectionsKt.emptyList();
        }
        List<ArchiveEntryMetadata> list = entries;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ArchiveEntryMetadata archiveEntryMetadata : list) {
            arrayList.add(new ArchivePackageFileRecord(archiveEntryMetadata.getTargetRelativePath(), archiveEntryMetadata.getSize(), archiveEntryMetadata.getCrc32(), (String) null, 8, (DefaultConstructorMarker) null));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return null;
        }
        if (isRebasedPlannedJournal(archivePackageJournalEntry, archivePackage)) {
            return ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, null, 0L, null, null, arrayList2, null, 0L, null, 479, null);
        }
        if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED && archivePackageJournalEntry.getPreviousCommitted() == null && archivePackageJournalEntry.getPreviousFiles().isEmpty()) {
            try {
                if (Intrinsics.areEqual(archivePackageJournalEntry.getPackageId(), archivePackage.getId())) {
                    if (archivePackageJournalEntry.getArchiveSize() == archivePackage.getArchiveSize() && archivePackageJournalEntry.getArchiveCrc32() == archivePackage.getCrc32()) {
                        return ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, null, 0L, null, null, arrayList2, null, 0L, null, 479, null);
                    }
                    if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED) {
                        return ArchivePhaseTransitions.INSTANCE.beginUpdate(archivePackageJournalEntry, new ArchivePackageIdentity(archivePackage.getId(), archivePackage.getArchiveSize(), archivePackage.getCrc32()), arrayList2, ArchivePackagePhase.PLANNED, archivePackageJournalEntry.getPhaseUpdatedAtEpochMs());
                    }
                    return null;
                }
                return null;
            } catch (CancellationException e) {
                throw e;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private final boolean isRebasedPlannedJournal(ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackage archivePackage) {
        return archivePackageJournalEntry.getPhase() == ArchivePackagePhase.PLANNED && Intrinsics.areEqual(archivePackageJournalEntry.getPackageId(), archivePackage.getId()) && archivePackageJournalEntry.getArchiveSize() == archivePackage.getArchiveSize() && archivePackageJournalEntry.getArchiveCrc32() == archivePackage.getCrc32() && archivePackageJournalEntry.getPreviousCommitted() != null && !archivePackageJournalEntry.getPreviousFiles().isEmpty() && !archivePackageJournalEntry.getDesiredFiles().isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Long estimateFromObservedIndex(ArchivePackage archivePackage, List<ArchivePackageFileRecord> list, List<ArchivePackageFileRecord> list2, ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata) {
        Map uniqueByPath;
        Long valueOf;
        long longValue;
        Object obj;
        Map<String, ArchivePackageFileRecord> uniqueByPath2 = uniqueByPath(list);
        if (uniqueByPath2 == null || (uniqueByPath = uniqueByPath(archiveResolvedZipIndexMetadata.getFiles(), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveDownloadEstimator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ArchiveSelectiveDownloadEstimator.estimateFromObservedIndex$lambda$0((ArchiveResolvedZipFileMetadata) obj2);
            }
        })) == null || !Intrinsics.areEqual(uniqueByPath2.keySet(), uniqueByPath.keySet())) {
            return null;
        }
        if (!uniqueByPath2.isEmpty()) {
            for (Map.Entry<String, ArchivePackageFileRecord> entry : uniqueByPath2.entrySet()) {
                ArchivePackageFileRecord value = entry.getValue();
                ArchiveResolvedZipFileMetadata archiveResolvedZipFileMetadata = (ArchiveResolvedZipFileMetadata) uniqueByPath.get(entry.getKey());
                if (archiveResolvedZipFileMetadata == null || archiveResolvedZipFileMetadata.getSize() != value.getSize() || archiveResolvedZipFileMetadata.getCrc32() != value.getCrc32()) {
                    return null;
                }
                while (r12.hasNext()) {
                }
            }
        }
        List sorted = CollectionsKt.sorted(CollectionsKt.distinct(archiveResolvedZipIndexMetadata.getLocalHeaderOffsets()));
        if (sorted.isEmpty()) {
            return null;
        }
        long indexFetchBytes = archiveResolvedZipIndexMetadata.getIndexFetchBytes();
        try {
            for (ArchivePackageFileRecord archivePackageFileRecord : list2) {
                String relativePath = archivePackageFileRecord.getRelativePath();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = relativePath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                ArchiveResolvedZipFileMetadata archiveResolvedZipFileMetadata2 = (ArchiveResolvedZipFileMetadata) uniqueByPath.get(lowerCase);
                if (archiveResolvedZipFileMetadata2 == null) {
                    return null;
                }
                Iterator it = sorted.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((Number) obj).longValue() > archiveResolvedZipFileMetadata2.getLocalHeaderOffset()) {
                        break;
                    }
                }
                Long l = (Long) obj;
                long subtractExact = Math.subtractExact(l != null ? l.longValue() : archiveResolvedZipIndexMetadata.getCentralDirectoryOffset(), archiveResolvedZipFileMetadata2.getLocalHeaderOffset());
                if (subtractExact < Math.addExact(30L, archiveResolvedZipFileMetadata2.getCompressedSize())) {
                    return null;
                }
                indexFetchBytes = Math.addExact(indexFetchBytes, subtractExact);
            }
            valueOf = Long.valueOf(indexFetchBytes);
            longValue = valueOf.longValue();
        } catch (ArithmeticException unused) {
        }
        if (1 > longValue || longValue >= archivePackage.getArchiveSize()) {
            return null;
        }
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String estimateFromObservedIndex$lambda$0(ArchiveResolvedZipFileMetadata file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.getTargetRelativePath();
    }

    private final Map<String, ArchivePackageFileRecord> uniqueByPath(List<ArchivePackageFileRecord> list) {
        return uniqueByPath(list, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveDownloadEstimator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchiveSelectiveDownloadEstimator.uniqueByPath$lambda$0((ArchivePackageFileRecord) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String uniqueByPath$lambda$0(ArchivePackageFileRecord file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.getRelativePath();
    }

    private final <T> Map<String, T> uniqueByPath(List<? extends T> list, Function1<? super T, String> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = function1.invoke(obj).toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (linkedHashMap.put(lowerCase, obj) != null) {
                return null;
            }
        }
        return linkedHashMap;
    }

    /* compiled from: ArchiveSelectiveDownloadEstimator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator$Companion;", "", "<init>", "()V", "ZIP_LOCAL_HEADER_FIXED_BYTES", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
