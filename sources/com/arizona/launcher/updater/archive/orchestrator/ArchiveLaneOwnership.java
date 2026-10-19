package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneOwnershipHandoff.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u0012Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveLaneOwnership;", "", "<init>", "()V", "fromManifest", "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "fromProofs", "proofs", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveOwnedFileProof;", "proofsFromManifest", "fromState", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "fromLoaded", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLaneOwnership {
    public static final int $stable = 0;
    public static final ArchiveLaneOwnership INSTANCE = new ArchiveLaneOwnership();

    private ArchiveLaneOwnership() {
    }

    public final List<ArchiveOwnedPath> fromManifest(ArchiveManifest manifest) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        return fromProofs(proofsFromManifest(manifest));
    }

    public final List<ArchiveOwnedFileProof> proofsFromManifest(ArchiveManifest manifest) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        ArrayList arrayList = new ArrayList();
        for (ArchivePackage archivePackage : manifest.getPackages()) {
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries == null) {
                entries = CollectionsKt.emptyList();
            }
            List<ArchiveEntryMetadata> list = entries;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ArchiveEntryMetadata archiveEntryMetadata : list) {
                arrayList2.add(new ArchiveOwnedFileProof(archivePackage.getId(), archiveEntryMetadata.getTargetRelativePath(), archiveEntryMetadata.getSize(), archiveEntryMetadata.getCrc32(), null, 16, null));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public final List<ArchiveOwnedPath> fromState(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        List createListBuilder = CollectionsKt.createListBuilder();
        for (ArchivePackageJournalEntry archivePackageJournalEntry : state.getPackages()) {
            for (ArchivePackageFileRecord archivePackageFileRecord : CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) archivePackageJournalEntry.getFiles(), (Iterable) archivePackageJournalEntry.getPreviousFiles()), (Iterable) archivePackageJournalEntry.getDesiredFiles())) {
                createListBuilder.add(new ArchiveOwnedPath(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath()));
            }
        }
        for (ArchiveFileRetirementRecord archiveFileRetirementRecord : state.getPendingRetirements()) {
            createListBuilder.add(new ArchiveOwnedPath(archiveFileRetirementRecord.getPackageId(), archiveFileRetirementRecord.getRelativePath()));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.build(createListBuilder)) {
            String relativePath = ((ArchiveOwnedPath) obj).getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (hashSet.add(lowerCase)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<ArchiveOwnedPath> fromLoaded(ArchiveStateLoadResult state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, ArchiveStateLoadResult.Missing.INSTANCE)) {
            return CollectionsKt.emptyList();
        }
        if (state instanceof ArchiveStateLoadResult.Corrupt) {
            throw new IllegalArgumentException("Archive ownership state is corrupt: " + ((ArchiveStateLoadResult.Corrupt) state).getReason());
        } else if (state instanceof ArchiveStateLoadResult.Loaded) {
            return fromState(((ArchiveStateLoadResult.Loaded) state).getState());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final List<ArchiveOwnedPath> fromProofs(Iterable<ArchiveOwnedFileProof> proofs) {
        Intrinsics.checkNotNullParameter(proofs, "proofs");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(proofs, 10));
        for (ArchiveOwnedFileProof archiveOwnedFileProof : proofs) {
            arrayList.add(archiveOwnedFileProof.toOwnedPath());
        }
        return arrayList;
    }
}
