package com.arizona.launcher.updater.archive.range;

import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveSelectiveEntryDiff.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveSelectiveEntryDiff;", "", "<init>", "()V", "plan", "Lcom/arizona/launcher/updater/archive/range/ArchiveEntryChangePlan;", "previousFiles", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "desiredFiles", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectiveEntryDiff {
    public static final int $stable = 0;
    public static final ArchiveSelectiveEntryDiff INSTANCE = new ArchiveSelectiveEntryDiff();

    private ArchiveSelectiveEntryDiff() {
    }

    public final ArchiveEntryChangePlan plan(List<ArchivePackageFileRecord> previousFiles, List<ArchivePackageFileRecord> desiredFiles) {
        Intrinsics.checkNotNullParameter(previousFiles, "previousFiles");
        Intrinsics.checkNotNullParameter(desiredFiles, "desiredFiles");
        List<ArchivePackageFileRecord> list = previousFiles;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            String relativePath = ((ArchivePackageFileRecord) obj).getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ArchivePackageFileRecord archivePackageFileRecord : desiredFiles) {
            String relativePath2 = archivePackageFileRecord.getRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = relativePath2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            ArchivePackageFileRecord archivePackageFileRecord2 = (ArchivePackageFileRecord) linkedHashMap.get(lowerCase2);
            if (archivePackageFileRecord2 != null && archivePackageFileRecord2.getSize() == archivePackageFileRecord.getSize() && archivePackageFileRecord2.getCrc32() == archivePackageFileRecord.getCrc32()) {
                arrayList.add(archivePackageFileRecord);
            } else {
                arrayList2.add(archivePackageFileRecord);
            }
        }
        return new ArchiveEntryChangePlan(arrayList, arrayList2);
    }
}
