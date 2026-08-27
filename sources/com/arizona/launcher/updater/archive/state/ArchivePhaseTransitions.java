package com.arizona.launcher.updater.archive.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateValidation.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006Jr\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ:\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00162\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0014R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0002¨\u0006\""}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePhaseTransitions;", "", "<init>", "()V", "allowed", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "", "isAllowed", "", "from", TypedValues.TransitionType.S_TO, "requireAllowed", "", "packageId", "", "transition", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "entry", "bytesDownloaded", "", "previousCommitted", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "desiredFiles", "previousFiles", "phaseUpdatedAtEpochMs", "lastError", "beginUpdate", "committed", "newIdentity", "targetPhase", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePhaseTransitions {
    public static final int $stable = 0;
    public static final ArchivePhaseTransitions INSTANCE = new ArchivePhaseTransitions();
    private static final Map<ArchivePackagePhase, Set<ArchivePackagePhase>> allowed = MapsKt.mapOf(TuplesKt.to(ArchivePackagePhase.PLANNED, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.PLANNED, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.DOWNLOADING, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.DOWNLOADING, ArchivePackagePhase.DOWNLOADED, ArchivePackagePhase.PLANNED, ArchivePackagePhase.EXTRACTING})), TuplesKt.to(ArchivePackagePhase.DOWNLOADED, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.DOWNLOADED, ArchivePackagePhase.VERIFYING, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.VERIFYING, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.VERIFYING, ArchivePackagePhase.VERIFIED, ArchivePackagePhase.DOWNLOADED, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.VERIFIED, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.VERIFIED, ArchivePackagePhase.EXTRACTING, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.EXTRACTING, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.EXTRACTING, ArchivePackagePhase.EXTRACTED, ArchivePackagePhase.VERIFIED, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.EXTRACTED, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.EXTRACTED, ArchivePackagePhase.COMMITTING, ArchivePackagePhase.VERIFIED, ArchivePackagePhase.DOWNLOADING})), TuplesKt.to(ArchivePackagePhase.COMMITTING, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.COMMITTING, ArchivePackagePhase.COMMITTED})), TuplesKt.to(ArchivePackagePhase.COMMITTED, SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.COMMITTED, ArchivePackagePhase.PLANNED, ArchivePackagePhase.DOWNLOADING})));

    private ArchivePhaseTransitions() {
    }

    public final boolean isAllowed(ArchivePackagePhase from, ArchivePackagePhase to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Set<ArchivePackagePhase> set = allowed.get(from);
        return set != null && set.contains(to);
    }

    public final void requireAllowed(String packageId, ArchivePackagePhase from, ArchivePackagePhase to) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        if (!isAllowed(from, to)) {
            throw new IllegalArchivePhaseTransitionException(packageId, from, to);
        }
    }

    public static /* synthetic */ ArchivePackageJournalEntry transition$default(ArchivePhaseTransitions archivePhaseTransitions, ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackagePhase archivePackagePhase, long j, ArchivePackageIdentity archivePackageIdentity, List list, List list2, List list3, long j2, String str, int i, Object obj) {
        return archivePhaseTransitions.transition(archivePackageJournalEntry, archivePackagePhase, (i & 4) != 0 ? archivePackageJournalEntry.getBytesDownloaded() : j, (i & 8) != 0 ? archivePackageJournalEntry.getPreviousCommitted() : archivePackageIdentity, (i & 16) != 0 ? archivePackageJournalEntry.getFiles() : list, (i & 32) != 0 ? archivePackageJournalEntry.getDesiredFiles() : list2, (i & 64) != 0 ? archivePackageJournalEntry.getPreviousFiles() : list3, (i & 128) != 0 ? archivePackageJournalEntry.getPhaseUpdatedAtEpochMs() : j2, (i & 256) != 0 ? archivePackageJournalEntry.getLastError() : str);
    }

    public final ArchivePackageJournalEntry transition(ArchivePackageJournalEntry entry, ArchivePackagePhase to, long j, ArchivePackageIdentity archivePackageIdentity, List<ArchivePackageFileRecord> files, List<ArchivePackageFileRecord> desiredFiles, List<ArchivePackageFileRecord> previousFiles, long j2, String str) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(desiredFiles, "desiredFiles");
        Intrinsics.checkNotNullParameter(previousFiles, "previousFiles");
        requireAllowed(entry.getPackageId(), entry.getPhase(), to);
        ArchivePackageJournalEntry copy$default = ArchivePackageJournalEntry.copy$default(entry, null, to, j, to == ArchivePackagePhase.COMMITTED ? null : archivePackageIdentity, files, desiredFiles, to == ArchivePackagePhase.COMMITTED ? CollectionsKt.emptyList() : previousFiles, j2, str, 1, null);
        ArchiveStateValidation.INSTANCE.requireValidEntry(copy$default);
        return copy$default;
    }

    public static /* synthetic */ ArchivePackageJournalEntry beginUpdate$default(ArchivePhaseTransitions archivePhaseTransitions, ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackageIdentity archivePackageIdentity, List list, ArchivePackagePhase archivePackagePhase, long j, int i, Object obj) {
        List list2 = list;
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            archivePackagePhase = ArchivePackagePhase.DOWNLOADING;
        }
        ArchivePackagePhase archivePackagePhase2 = archivePackagePhase;
        if ((i & 16) != 0) {
            j = 0;
        }
        return archivePhaseTransitions.beginUpdate(archivePackageJournalEntry, archivePackageIdentity, list3, archivePackagePhase2, j);
    }

    public final ArchivePackageJournalEntry beginUpdate(ArchivePackageJournalEntry committed, ArchivePackageIdentity newIdentity, List<ArchivePackageFileRecord> desiredFiles, ArchivePackagePhase targetPhase, long j) {
        Intrinsics.checkNotNullParameter(committed, "committed");
        Intrinsics.checkNotNullParameter(newIdentity, "newIdentity");
        Intrinsics.checkNotNullParameter(desiredFiles, "desiredFiles");
        Intrinsics.checkNotNullParameter(targetPhase, "targetPhase");
        if (committed.getPhase() != ArchivePackagePhase.COMMITTED) {
            String packageId = committed.getPackageId();
            throw new ArchiveStateInvariantException("beginUpdate requires COMMITTED package '" + packageId + "', got " + committed.getPhase(), null, 2, null);
        } else if (!Intrinsics.areEqual(committed.getPackageId(), newIdentity.getPackageId())) {
            String packageId2 = committed.getPackageId();
            throw new ArchiveStateInvariantException("beginUpdate packageId mismatch: '" + packageId2 + "' vs '" + newIdentity.getPackageId() + "'", null, 2, null);
        } else {
            ArchiveStateValidation.requireValidIdentity$default(ArchiveStateValidation.INSTANCE, newIdentity, null, 2, null);
            requireAllowed(committed.getPackageId(), ArchivePackagePhase.COMMITTED, targetPhase);
            ArchivePackageJournalEntry archivePackageJournalEntry = new ArchivePackageJournalEntry(newIdentity, targetPhase, 0L, committed.getIdentity(), CollectionsKt.emptyList(), desiredFiles, committed.getFiles(), j, null);
            ArchiveStateValidation.INSTANCE.requireValidEntry(archivePackageJournalEntry);
            return archivePackageJournalEntry;
        }
    }
}
