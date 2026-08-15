package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchivePublishedPayloadReconciler.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePublishedPayloadReconciler;", "", "<init>", "()V", "matches", "", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePublishedPayloadReconciler {
    public static final int $stable = 0;
    public static final ArchivePublishedPayloadReconciler INSTANCE = new ArchivePublishedPayloadReconciler();

    private ArchivePublishedPayloadReconciler() {
    }

    public final boolean matches(ArchiveManifest manifest, ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.isPayloadCommitted() && ArchiveStateAdapter.INSTANCE.identitiesMatch(state, manifest)) {
            List<ArchivePackage> packages = manifest.getPackages();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
            for (Object obj : packages) {
                linkedHashMap.put(((ArchivePackage) obj).getId(), obj);
            }
            List<ArchivePackageJournalEntry> packages2 = state.getPackages();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages2, 10)), 16));
            for (Object obj2 : packages2) {
                linkedHashMap2.put(((ArchivePackageJournalEntry) obj2).getPackageId(), obj2);
            }
            if (Intrinsics.areEqual(linkedHashMap.keySet(), linkedHashMap2.keySet())) {
                if (linkedHashMap.isEmpty()) {
                    return true;
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    List<ArchiveEntryMetadata> entries = ((ArchivePackage) entry.getValue()).getEntries();
                    if (entries != null) {
                        List<ArchivePackageFileRecord> files = ((ArchivePackageJournalEntry) MapsKt.getValue(linkedHashMap2, str)).getFiles();
                        List<ArchiveEntryMetadata> list = entries;
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                        for (Object obj3 : list) {
                            String targetRelativePath = ((ArchiveEntryMetadata) obj3).getTargetRelativePath();
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String lowerCase = targetRelativePath.toLowerCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            linkedHashMap3.put(lowerCase, obj3);
                        }
                        List<ArchivePackageFileRecord> list2 = files;
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                        for (Object obj4 : list2) {
                            String relativePath = ((ArchivePackageFileRecord) obj4).getRelativePath();
                            Locale ROOT2 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                            String lowerCase2 = relativePath.toLowerCase(ROOT2);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            linkedHashMap4.put(lowerCase2, obj4);
                        }
                        if (linkedHashMap3.size() == entries.size() && linkedHashMap4.size() == files.size() && Intrinsics.areEqual(linkedHashMap3.keySet(), linkedHashMap4.keySet())) {
                            if (!linkedHashMap3.isEmpty()) {
                                for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                                    ArchiveEntryMetadata archiveEntryMetadata = (ArchiveEntryMetadata) entry2.getValue();
                                    ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) linkedHashMap4.get((String) entry2.getKey());
                                    if (archivePackageFileRecord != null) {
                                        if (archivePackageFileRecord.getSize() == archiveEntryMetadata.getSize()) {
                                            if (archivePackageFileRecord.getCrc32() != archiveEntryMetadata.getCrc32()) {
                                            }
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
