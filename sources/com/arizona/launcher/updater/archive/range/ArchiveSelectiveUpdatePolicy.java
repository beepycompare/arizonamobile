package com.arizona.launcher.updater.archive.range;

import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.planner.ArchivePlanReason;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectiveEntryDiff.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J>\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u0015\u0018\u00010\u0013\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00140\u0018H\u0002J\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveSelectiveUpdatePolicy;", "", "<init>", "()V", "publishedBinding", "Lcom/arizona/launcher/updater/archive/range/ArchivePublishedRepresentationBinding;", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "resolvedBinding", "Lcom/arizona/launcher/updater/archive/range/ArchiveResolvedRepresentationBinding;", "hasSelectiveRepresentationBinding", "", "remoteRegularEntriesMatchExpected", "remote", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "desired", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "uniqueByKey", "", "", ExifInterface.GPS_DIRECTION_TRUE, "items", "key", "Lkotlin/Function1;", "isCandidate", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", DiskLruCache.JOURNAL_FILE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectiveUpdatePolicy {
    public static final int $stable = 0;
    public static final ArchiveSelectiveUpdatePolicy INSTANCE = new ArchiveSelectiveUpdatePolicy();

    private ArchiveSelectiveUpdatePolicy() {
    }

    public final ArchivePublishedRepresentationBinding publishedBinding(ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        return new ArchivePublishedRepresentationBinding(archivePackage.getImmutableVersionedUrl(), null, Sha256Digest.Companion.parse(archivePackage.getCentralDirectorySha256()), 2, null);
    }

    public final ArchiveResolvedRepresentationBinding resolvedBinding(ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        return new ArchiveResolvedRepresentationBinding(Sha256Digest.Companion.parse(archivePackage.getResolvedCentralDirectorySha256()));
    }

    public final boolean hasSelectiveRepresentationBinding(ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        return publishedBinding(archivePackage).getHasTrustAnchor() || resolvedBinding(archivePackage).getHasTrustAnchor();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remoteRegularEntriesMatchExpected(RemoteZipIndex remote, ArchivePackage archivePackage, List<ArchivePackageFileRecord> desired) {
        Map uniqueByKey;
        Map uniqueByKey2;
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        Intrinsics.checkNotNullParameter(desired, "desired");
        List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
        if (entries != null && remote.getTotalUncompressedBytes() == archivePackage.getInstalledSize()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : remote.getEntries()) {
                if (!((RemoteZipEntry) obj).isDirectory()) {
                    arrayList.add(obj);
                }
            }
            Map uniqueByKey3 = uniqueByKey(arrayList, new Function1() { // from class: com.arizona.launcher.updater.archive.range.ArchiveSelectiveUpdatePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ArchiveSelectiveUpdatePolicy.remoteRegularEntriesMatchExpected$lambda$1((RemoteZipEntry) obj2);
                }
            });
            if (uniqueByKey3 == null || (uniqueByKey = uniqueByKey(entries, new Function1() { // from class: com.arizona.launcher.updater.archive.range.ArchiveSelectiveUpdatePolicy$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ArchiveSelectiveUpdatePolicy.remoteRegularEntriesMatchExpected$lambda$2((ArchiveEntryMetadata) obj2);
                }
            })) == null || (uniqueByKey2 = uniqueByKey(desired, new Function1() { // from class: com.arizona.launcher.updater.archive.range.ArchiveSelectiveUpdatePolicy$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ArchiveSelectiveUpdatePolicy.remoteRegularEntriesMatchExpected$lambda$3((ArchivePackageFileRecord) obj2);
                }
            })) == null || !Intrinsics.areEqual(uniqueByKey3.keySet(), uniqueByKey.keySet()) || !Intrinsics.areEqual(uniqueByKey.keySet(), uniqueByKey2.keySet())) {
                return false;
            }
            Set<String> keySet = uniqueByKey.keySet();
            if ((keySet instanceof Collection) && keySet.isEmpty()) {
                return true;
            }
            for (String str : keySet) {
                ArchiveEntryMetadata archiveEntryMetadata = (ArchiveEntryMetadata) MapsKt.getValue(uniqueByKey, str);
                RemoteZipEntry remoteZipEntry = (RemoteZipEntry) MapsKt.getValue(uniqueByKey3, str);
                ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) MapsKt.getValue(uniqueByKey2, str);
                if (archiveEntryMetadata.getSize() != archivePackageFileRecord.getSize() || archiveEntryMetadata.getCrc32() != archivePackageFileRecord.getCrc32() || remoteZipEntry.getSize() != archivePackageFileRecord.getSize() || remoteZipEntry.getCrc32() != archivePackageFileRecord.getCrc32()) {
                    return false;
                }
                while (r12.hasNext()) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String remoteRegularEntriesMatchExpected$lambda$1(RemoteZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        String target = entry.getTarget();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = target.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String remoteRegularEntriesMatchExpected$lambda$2(ArchiveEntryMetadata entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        String targetRelativePath = entry.getTargetRelativePath();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = targetRelativePath.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String remoteRegularEntriesMatchExpected$lambda$3(ArchivePackageFileRecord file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String relativePath = file.getRelativePath();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = relativePath.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final <T> Map<String, T> uniqueByKey(List<? extends T> list, Function1<? super T, String> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (linkedHashMap.put(function1.invoke(obj), obj) != null) {
                return null;
            }
        }
        return linkedHashMap;
    }

    public final boolean isCandidate(ArchiveUpdatePlan plan, ArchivePackageJournalEntry journal, ArchivePackage archivePackage) {
        List<ArchiveEntryMetadata> entries;
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        if (plan.getType() != ArchivePlanType.FULL_UPDATE || plan.getReason() == ArchivePlanReason.PAYLOAD_REPAIR || plan.getReason() == ArchivePlanReason.REPAIR_REQUESTED || (entries = archivePackage.getEntries()) == null || entries.isEmpty() || !hasSelectiveRepresentationBinding(archivePackage) || journal.getPreviousCommitted() == null || journal.getPreviousFiles().isEmpty() || journal.getDesiredFiles().isEmpty()) {
            return false;
        }
        ArchiveEntryChangePlan plan2 = ArchiveSelectiveEntryDiff.INSTANCE.plan(journal.getPreviousFiles(), journal.getDesiredFiles());
        return (plan2.getReusable().isEmpty() || plan2.getToFetch().isEmpty()) ? false : true;
    }
}
