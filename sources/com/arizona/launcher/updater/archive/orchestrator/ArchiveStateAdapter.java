package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveLocalState;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchiveStateInvariantException;
import com.arizona.launcher.updater.archive.state.ArchiveStateValidation;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* compiled from: ArchiveStateAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStateAdapter;", "", "<init>", "()V", "createInitialState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "nowEpochMs", "", "toPlannerState", "Lcom/arizona/launcher/updater/archive/model/ArchiveLocalState;", RemoteConfigConstants.ResponseFieldKey.STATE, "sameIdentityRepairPackageIds", "", "", "replacePackage", "replacement", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "markPayloadMetadataReconciled", "identitiesMatch", "", "manifestId", "transactionId", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStateAdapter {
    public static final int $stable = 0;
    public static final ArchiveStateAdapter INSTANCE = new ArchiveStateAdapter();

    private ArchiveStateAdapter() {
    }

    public final ArchiveUpdaterState createInitialState(ArchiveManifest manifest, long j) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        String manifestId = manifestId(manifest);
        String manifestVersion = manifest.getManifestVersion();
        int schemaVersion = manifest.getSchemaVersion();
        String wireName = manifest.getSelectedGpu().getWireName();
        List<ArchivePackage> packages = manifest.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackage archivePackage : packages) {
            ArchivePackageIdentity archivePackageIdentity = new ArchivePackageIdentity(archivePackage.getId(), archivePackage.getArchiveSize(), archivePackage.getCrc32());
            ArchivePackagePhase archivePackagePhase = ArchivePackagePhase.PLANNED;
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries == null) {
                entries = CollectionsKt.emptyList();
            }
            List<ArchiveEntryMetadata> list = entries;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ArchiveEntryMetadata archiveEntryMetadata : list) {
                arrayList2.add(new ArchivePackageFileRecord(archiveEntryMetadata.getTargetRelativePath(), archiveEntryMetadata.getSize(), archiveEntryMetadata.getCrc32(), (String) null, 8, (DefaultConstructorMarker) null));
            }
            arrayList.add(new ArchivePackageJournalEntry(archivePackageIdentity, archivePackagePhase, 0L, (ArchivePackageIdentity) null, (List) null, arrayList2, (List) null, j, (String) null, 348, (DefaultConstructorMarker) null));
        }
        ArchiveUpdaterState archiveUpdaterState = new ArchiveUpdaterState(0, manifestId, manifestVersion, schemaVersion, wireName, (List) arrayList, (List) null, false, j, (int) DownloaderService.STATUS_PAUSED_BY_APP, (DefaultConstructorMarker) null);
        ArchiveStateValidation.INSTANCE.requireValidState(archiveUpdaterState);
        return archiveUpdaterState;
    }

    public final ArchiveLocalState toPlannerState(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ArchiveStateValidation.INSTANCE.requireValidState(state);
        ArchiveGpu fromWireName = ArchiveGpu.Companion.fromWireName(state.getSelectedGpu());
        if (fromWireName == null) {
            throw new ArchiveStateInvariantException("Unknown selectedGpu '" + state.getSelectedGpu() + "'", null, 2, null);
        }
        int manifestSchemaVersion = state.getManifestSchemaVersion();
        String manifestVersion = state.getManifestVersion();
        boolean isPayloadCommitted = state.isPayloadCommitted();
        List<ArchivePackageJournalEntry> packages = state.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            arrayList.add(new com.arizona.launcher.updater.archive.model.ArchivePackageIdentity(archivePackageJournalEntry.getPackageId(), archivePackageJournalEntry.getArchiveSize(), archivePackageJournalEntry.getArchiveCrc32()));
        }
        return new ArchiveLocalState(manifestSchemaVersion, manifestVersion, fromWireName, isPayloadCommitted, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> sameIdentityRepairPackageIds(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ArchiveStateValidation.INSTANCE.requireValidState(state);
        ArrayList arrayList = new ArrayList();
        for (Object obj : state.getPackages()) {
            if (((ArchivePackageJournalEntry) obj).getPhase() != ArchivePackagePhase.COMMITTED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return null;
        }
        ArrayList<ArchivePackageJournalEntry> arrayList3 = arrayList2;
        if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
            for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList3) {
                if (!Intrinsics.areEqual(archivePackageJournalEntry.getPreviousCommitted(), archivePackageJournalEntry.getIdentity()) || archivePackageJournalEntry.getPreviousFiles().isEmpty()) {
                    return null;
                }
                while (r4.hasNext()) {
                }
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry2 : arrayList3) {
            arrayList4.add(archivePackageJournalEntry2.getPackageId());
        }
        return arrayList4;
    }

    public final ArchiveUpdaterState replacePackage(ArchiveUpdaterState state, ArchivePackageJournalEntry replacement, long j) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Iterator<ArchivePackageJournalEntry> it = state.getPackages().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getPackageId(), replacement.getPackageId())) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            String packageId = replacement.getPackageId();
            throw new ArchiveStateInvariantException("Package '" + packageId + "' is not part of manifest '" + state.getManifestId() + "'", null, 2, null);
        }
        List mutableList = CollectionsKt.toMutableList((Collection) state.getPackages());
        mutableList.set(i, replacement);
        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(state, 0, null, null, 0, null, mutableList, null, false, j, 95, null);
        ArchiveStateValidation.INSTANCE.requireValidState(copy$default);
        return copy$default;
    }

    public final ArchiveUpdaterState markPayloadMetadataReconciled(ArchiveUpdaterState state, long j) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!state.isPayloadCommitted()) {
            throw new ArchiveStateInvariantException("Cannot reconcile payload metadata before every archive package is committed", null, 2, null);
        }
        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(state, 0, null, null, 0, null, null, null, true, j, 127, null);
        ArchiveStateValidation.INSTANCE.requireValidState(copy$default);
        return copy$default;
    }

    public final boolean identitiesMatch(ArchiveUpdaterState state, ArchiveManifest manifest) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        if (state.getManifestSchemaVersion() == manifest.getSchemaVersion() && Intrinsics.areEqual(state.getManifestVersion(), manifest.getManifestVersion()) && Intrinsics.areEqual(state.getSelectedGpu(), manifest.getSelectedGpu().getWireName())) {
            List<ArchivePackageJournalEntry> packages = state.getPackages();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
            for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
                Pair pair = TuplesKt.to(archivePackageJournalEntry.getPackageId(), new Triple(Long.valueOf(archivePackageJournalEntry.getArchiveSize()), Long.valueOf(archivePackageJournalEntry.getArchiveCrc32()), true));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            List<ArchivePackage> packages2 = manifest.getPackages();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages2, 10)), 16));
            for (ArchivePackage archivePackage : packages2) {
                Pair pair2 = TuplesKt.to(archivePackage.getId(), new Triple(Long.valueOf(archivePackage.getArchiveSize()), Long.valueOf(archivePackage.getCrc32()), true));
                linkedHashMap2.put(pair2.getFirst(), pair2.getSecond());
            }
            return Intrinsics.areEqual(linkedHashMap, linkedHashMap2);
        }
        return false;
    }

    public final String manifestId(ArchiveManifest manifest) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        String wireName = manifest.getSelectedGpu().getWireName();
        return wireName + StringUtils.PROCESS_POSTFIX_DELIMITER + manifest.getManifestVersion();
    }

    public final String transactionId(String manifestId) {
        Intrinsics.checkNotNullParameter(manifestId, "manifestId");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = manifestId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return StringsKt.take(ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveStateAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchiveStateAdapter.transactionId$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null), 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence transactionId$lambda$0(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
