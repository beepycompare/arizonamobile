package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import android.content.SharedPreferences;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.download.FileArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveViceCityDeleteFinalizeResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveViceCityDeleteRecoveryResult;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentDeleteResult;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentInspection;
import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiffPlanner;
import com.arizona.launcher.updater.archive.transaction.ArchiveRetirementResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: ViceCityArchiveContentManager.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 M2\u00020\u0001:\u0003KLMB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010!\u001a\u00020\"*\u00020#H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0002J\u0016\u0010,\u001a\u00020-2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020+H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010/\u001a\u00020+H\u0002J\u0010\u00102\u001a\u0002032\u0006\u0010/\u001a\u00020+H\u0002J\u0016\u00104\u001a\u00020-2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060%H\u0002J\u0010\u00107\u001a\u00020(2\u0006\u00108\u001a\u000206H\u0002J\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u000203H\u0002J\u0018\u0010<\u001a\u00020(2\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u000203H\u0002J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u000203H\u0002J\u0018\u0010?\u001a\u0002012\u0006\u0010:\u001a\u0002032\u0006\u0010/\u001a\u00020+H\u0002J\u0018\u0010@\u001a\u0002012\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u000203H\u0002J\u0018\u0010A\u001a\u00020-2\u0006\u0010:\u001a\u0002032\u0006\u0010B\u001a\u00020+H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010:\u001a\u0002032\u0006\u0010B\u001a\u00020+H\u0002J\u0018\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020(H\u0002J\u0010\u0010H\u001a\u00020+*\u00060Ij\u0002`JH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bO\u0012\b\bP\u0012\u0004\b\u0003\u0010\u0000¨\u0006N"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager;", "", "storageRoots", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "deleteMarker", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveDeleteMarker;", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "artifactCleaner", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "retirementClient", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveDeleteMarker;Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;)V", "inspect", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection;", "delete", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentDeleteResult;", "recoverPendingDelete", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveViceCityDeleteRecoveryResult;", "finalizePendingDelete", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveViceCityDeleteFinalizeResult;", "completePendingDelete", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion;", "deleteSnapshot", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$ContentSnapshot;", "finishMissingStateDelete", "snapshotOf", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "toOwnedPath", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "Lcom/arizona/launcher/updater/archive/state/ArchiveFileRetirementRecord;", "deduplicateOwnership", "", "ownership", "measureBytes", "", "retirementTrashBytes", "transactionId", "", "validateLiveOwnership", "", "liveFileBytes", "relativePath", "inspectLiveNode", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", "liveFile", "Ljava/io/File;", "validateArtifacts", "identities", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "artifactBytes", "identity", "exactArtifactFileBytes", "root", "candidate", "exactArtifactTreeBytes", "treeBytes", "node", "inspectRelative", "inspectDescendant", "requireDirectory", Constants.ScionAnalytics.PARAM_LABEL, "requireDirectoryIfPresent", "", "addExact", "first", "second", "safeMessage", "Ljava/lang/Exception;", "Lkotlin/Exception;", "DeleteCompletion", "ContentSnapshot", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViceCityArchiveContentManager {
    private static final String DELETE_TRANSACTION_ID = "vice-city-delete";
    private static final String PREFERENCES_NAME = "vice_city_archive_content";
    private final ArchivePackageArtifactCleaner artifactCleaner;
    private final ViceCityArchiveDeleteMarker deleteMarker;
    private final ArchiveNodeInspector nodeInspector;
    private final ArchiveRetirementClient retirementClient;
    private final DurableArchiveStateStore stateStore;
    private final ArchiveUpdaterStorageRoots storageRoots;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = (ArchivePackageArtifactCleaner.$stable | DurableArchiveStateStore.$stable) | ArchiveUpdaterStorageRoots.$stable;

    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveFsNodeType.values().length];
            try {
                iArr[ArchiveFsNodeType.ABSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveFsNodeType.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ViceCityArchiveContentManager(ArchiveUpdaterStorageRoots storageRoots, DurableArchiveStateStore stateStore, ViceCityArchiveDeleteMarker deleteMarker, ArchiveNodeInspector nodeInspector, ArchivePackageArtifactCleaner artifactCleaner, ArchiveRetirementClient retirementClient) {
        Intrinsics.checkNotNullParameter(storageRoots, "storageRoots");
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(deleteMarker, "deleteMarker");
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        Intrinsics.checkNotNullParameter(artifactCleaner, "artifactCleaner");
        Intrinsics.checkNotNullParameter(retirementClient, "retirementClient");
        this.storageRoots = storageRoots;
        this.stateStore = stateStore;
        this.deleteMarker = deleteMarker;
        this.nodeInspector = nodeInspector;
        this.artifactCleaner = artifactCleaner;
        this.retirementClient = retirementClient;
    }

    public /* synthetic */ ViceCityArchiveContentManager(ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots, DurableArchiveStateStore durableArchiveStateStore, ViceCityArchiveDeleteMarker viceCityArchiveDeleteMarker, AndroidArchiveNodeInspector androidArchiveNodeInspector, ArchivePackageArtifactCleaner archivePackageArtifactCleaner, ArchiveRetirementClient archiveRetirementClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveUpdaterStorageRoots, durableArchiveStateStore, viceCityArchiveDeleteMarker, (i & 8) != 0 ? AndroidArchiveNodeInspector.INSTANCE : androidArchiveNodeInspector, (i & 16) != 0 ? ArchivePackageArtifactCleaner.Companion.forAndroid() : archivePackageArtifactCleaner, (i & 32) != 0 ? ViceCityArchiveContentManagerKt.viceCityRetirementClient(archiveUpdaterStorageRoots.getGameRoot(), archiveUpdaterStorageRoots.getWorkRoot()) : archiveRetirementClient);
    }

    public final ViceCityArchiveContentInspection inspect() {
        try {
            ArchiveStateLoadResult load = this.stateStore.load();
            if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
                return new ViceCityArchiveContentInspection.Success(0L);
            }
            if (load instanceof ArchiveStateLoadResult.Corrupt) {
                return new ViceCityArchiveContentInspection.Failure("Vice-City archive state is corrupt: " + ((ArchiveStateLoadResult.Corrupt) load).getReason());
            } else if (!(load instanceof ArchiveStateLoadResult.Loaded)) {
                throw new NoWhenBranchMatchedException();
            } else {
                return new ViceCityArchiveContentInspection.Success(measureBytes(snapshotOf(((ArchiveStateLoadResult.Loaded) load).getState())));
            }
        } catch (Exception e) {
            return new ViceCityArchiveContentInspection.Failure(safeMessage(e));
        }
    }

    public final ViceCityArchiveContentDeleteResult delete() {
        try {
            this.deleteMarker.markPending();
            DeleteCompletion completePendingDelete = completePendingDelete();
            if (completePendingDelete instanceof DeleteCompletion.Success) {
                return ViceCityArchiveContentDeleteResult.Success.INSTANCE;
            }
            if (completePendingDelete instanceof DeleteCompletion.Failure) {
                return new ViceCityArchiveContentDeleteResult.Failure(((DeleteCompletion.Failure) completePendingDelete).getDetail());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return new ViceCityArchiveContentDeleteResult.Failure(safeMessage(e));
        }
    }

    public final ArchiveViceCityDeleteRecoveryResult recoverPendingDelete() {
        try {
            if (!this.deleteMarker.isPending()) {
                return ArchiveViceCityDeleteRecoveryResult.NoPending.INSTANCE;
            }
            DeleteCompletion completePendingDelete = completePendingDelete();
            if (completePendingDelete instanceof DeleteCompletion.Success) {
                return ArchiveViceCityDeleteRecoveryResult.Recovered.INSTANCE;
            }
            if (completePendingDelete instanceof DeleteCompletion.Failure) {
                return new ArchiveViceCityDeleteRecoveryResult.Failure(((DeleteCompletion.Failure) completePendingDelete).getDetail());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            return new ArchiveViceCityDeleteRecoveryResult.Failure(safeMessage(e));
        }
    }

    public final ArchiveViceCityDeleteFinalizeResult finalizePendingDelete() {
        try {
            if (!this.deleteMarker.isPending()) {
                return ArchiveViceCityDeleteFinalizeResult.NoPending.INSTANCE;
            }
            DeleteCompletion completePendingDelete = completePendingDelete();
            if (completePendingDelete instanceof DeleteCompletion.Failure) {
                return new ArchiveViceCityDeleteFinalizeResult.Failure(((DeleteCompletion.Failure) completePendingDelete).getDetail());
            }
            if (!Intrinsics.areEqual(completePendingDelete, DeleteCompletion.Success.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            this.deleteMarker.clearPending();
            return ArchiveViceCityDeleteFinalizeResult.Finalized.INSTANCE;
        } catch (Exception e) {
            return new ArchiveViceCityDeleteFinalizeResult.Failure(safeMessage(e));
        }
    }

    private final DeleteCompletion completePendingDelete() {
        ArchiveStateLoadResult load = this.stateStore.load();
        if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
            return finishMissingStateDelete();
        }
        if (load instanceof ArchiveStateLoadResult.Corrupt) {
            return new DeleteCompletion.Failure("Vice-City archive state is corrupt: " + ((ArchiveStateLoadResult.Corrupt) load).getReason());
        } else if (load instanceof ArchiveStateLoadResult.Loaded) {
            return deleteSnapshot(snapshotOf(((ArchiveStateLoadResult.Loaded) load).getState()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final DeleteCompletion deleteSnapshot(ContentSnapshot contentSnapshot) {
        validateLiveOwnership(contentSnapshot.getLiveOwnership());
        validateArtifacts(contentSnapshot.getIdentities());
        ArchiveRetirementResult quarantine = this.retirementClient.quarantine(DELETE_TRANSACTION_ID, contentSnapshot.getLiveOwnership());
        if (quarantine instanceof ArchiveRetirementResult.Failure) {
            ArchiveRetirementResult.Failure failure = (ArchiveRetirementResult.Failure) quarantine;
            Object detail = failure.getDetail();
            if (detail == null) {
                detail = failure.getCode();
            }
            return new DeleteCompletion.Failure("Unable to quarantine Vice-City files: " + detail);
        } else if (!(quarantine instanceof ArchiveRetirementResult.Success)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ArchiveTrashCleanupResult cleanup = this.retirementClient.cleanup(DELETE_TRANSACTION_ID);
            if (cleanup instanceof ArchiveTrashCleanupResult.Failure) {
                ArchiveTrashCleanupResult.Failure failure2 = (ArchiveTrashCleanupResult.Failure) cleanup;
                Object detail2 = failure2.getDetail();
                if (detail2 == null) {
                    detail2 = failure2.getCode();
                }
                return new DeleteCompletion.Failure("Unable to remove quarantined Vice-City files: " + detail2);
            } else if (!(cleanup instanceof ArchiveTrashCleanupResult.Success)) {
                throw new NoWhenBranchMatchedException();
            } else {
                ArchiveTrashCleanupResult cleanup2 = this.retirementClient.cleanup(contentSnapshot.getStateTransactionId());
                if (cleanup2 instanceof ArchiveTrashCleanupResult.Failure) {
                    ArchiveTrashCleanupResult.Failure failure3 = (ArchiveTrashCleanupResult.Failure) cleanup2;
                    Object detail3 = failure3.getDetail();
                    if (detail3 == null) {
                        detail3 = failure3.getCode();
                    }
                    return new DeleteCompletion.Failure("Unable to remove interrupted Vice-City retirement: " + detail3);
                } else if (!(cleanup2 instanceof ArchiveTrashCleanupResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    try {
                        ArchivePackageArtifactCleaner.cleanup$default(this.artifactCleaner, this.storageRoots.getGameRoot(), this.storageRoots.getDownloadRoot(), contentSnapshot.getIdentities(), this.storageRoots.getWorkRoot(), null, 16, null);
                        this.stateStore.clear();
                        return DeleteCompletion.Success.INSTANCE;
                    } catch (Exception e) {
                        return new DeleteCompletion.Failure(safeMessage(e));
                    }
                }
            }
        }
    }

    private final DeleteCompletion finishMissingStateDelete() {
        ArchiveTrashCleanupResult cleanup = this.retirementClient.cleanup(DELETE_TRANSACTION_ID);
        if (cleanup instanceof ArchiveTrashCleanupResult.Failure) {
            ArchiveTrashCleanupResult.Failure failure = (ArchiveTrashCleanupResult.Failure) cleanup;
            Object detail = failure.getDetail();
            if (detail == null) {
                detail = failure.getCode();
            }
            return new DeleteCompletion.Failure("Unable to remove quarantined Vice-City files: " + detail);
        } else if (cleanup instanceof ArchiveTrashCleanupResult.Success) {
            return DeleteCompletion.Success.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ContentSnapshot snapshotOf(ArchiveUpdaterState archiveUpdaterState) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ArchivePackageJournalEntry archivePackageJournalEntry : archiveUpdaterState.getPackages()) {
            linkedHashSet.add(archivePackageJournalEntry.getIdentity());
            ArchivePackageIdentity previousCommitted = archivePackageJournalEntry.getPreviousCommitted();
            if (previousCommitted != null) {
                linkedHashSet.add(previousCommitted);
            }
            if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTING || archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED) {
                for (ArchivePackageFileRecord archivePackageFileRecord : archivePackageJournalEntry.getFiles()) {
                    arrayList.add(new ArchiveOwnedPath(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath()));
                }
            }
            for (ArchivePackageFileRecord archivePackageFileRecord2 : archivePackageJournalEntry.getPreviousFiles()) {
                arrayList.add(new ArchiveOwnedPath(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord2.getRelativePath()));
            }
        }
        for (ArchiveFileRetirementRecord archiveFileRetirementRecord : archiveUpdaterState.getPendingRetirements()) {
            arrayList.add(toOwnedPath(archiveFileRetirementRecord));
        }
        return new ContentSnapshot(deduplicateOwnership(arrayList), CollectionsKt.toList(linkedHashSet), ArchiveStateAdapter.INSTANCE.transactionId(archiveUpdaterState.getManifestId()));
    }

    private final ArchiveOwnedPath toOwnedPath(ArchiveFileRetirementRecord archiveFileRetirementRecord) {
        return new ArchiveOwnedPath(archiveFileRetirementRecord.getPackageId(), archiveFileRetirementRecord.getRelativePath());
    }

    private final List<ArchiveOwnedPath> deduplicateOwnership(List<ArchiveOwnedPath> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ArchiveOwnedPath archiveOwnedPath : list) {
            ArchiveOwnershipDiffPlanner.INSTANCE.validatedOwnership(CollectionsKt.listOf(archiveOwnedPath), "Vice-City ownership");
            String relativePath = archiveOwnedPath.getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            ArchiveOwnedPath archiveOwnedPath2 = (ArchiveOwnedPath) linkedHashMap.putIfAbsent(lowerCase, archiveOwnedPath);
            if (archiveOwnedPath2 != null && !Intrinsics.areEqual(archiveOwnedPath2.getPackageId(), archiveOwnedPath.getPackageId())) {
                String relativePath2 = archiveOwnedPath.getRelativePath();
                String packageId = archiveOwnedPath2.getPackageId();
                throw new IOException("Vice-City state assigns '" + relativePath2 + "' to both '" + packageId + "' and '" + archiveOwnedPath.getPackageId() + "'");
            }
        }
        ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner = ArchiveOwnershipDiffPlanner.INSTANCE;
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(archiveOwnershipDiffPlanner.validatedOwnership(values, "Vice-City ownership").values());
    }

    private final long measureBytes(ContentSnapshot contentSnapshot) {
        long j = 0;
        for (ArchiveOwnedPath archiveOwnedPath : contentSnapshot.getLiveOwnership()) {
            j = addExact(j, liveFileBytes(archiveOwnedPath.getRelativePath()));
        }
        for (ArchivePackageIdentity archivePackageIdentity : contentSnapshot.getIdentities()) {
            j = addExact(j, artifactBytes(archivePackageIdentity));
        }
        return addExact(j, retirementTrashBytes(contentSnapshot.getStateTransactionId()));
    }

    private final long retirementTrashBytes(String str) {
        File file = new File(this.storageRoots.getWorkRoot(), ArchiveFileRetirement.TRANSACTIONS_ROOT);
        return exactArtifactTreeBytes(file, new File(file, str + "/retired"));
    }

    private final void validateLiveOwnership(List<ArchiveOwnedPath> list) {
        if (list.isEmpty()) {
            return;
        }
        requireDirectory(this.storageRoots.getGameRoot(), "game root");
        for (ArchiveOwnedPath archiveOwnedPath : list) {
            int i = WhenMappings.$EnumSwitchMapping$0[inspectLiveNode(archiveOwnedPath.getRelativePath()).ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3) {
                    throw new IOException("Vice-City live path is a directory: " + archiveOwnedPath.getRelativePath());
                } else if (i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    throw new IOException("Vice-City live path is unsafe: " + archiveOwnedPath.getRelativePath());
                }
            }
        }
    }

    private final long liveFileBytes(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[inspectLiveNode(str).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 || i == 5) {
                        throw new IOException("Vice-City live path is unsafe: " + str);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                throw new IOException("Vice-City live path is a directory: " + str);
            }
            return RangesKt.coerceAtLeast(liveFile(str).length(), 0L);
        }
        return 0L;
    }

    private final ArchiveFsNodeType inspectLiveNode(String str) {
        if (this.nodeInspector.nodeType(this.storageRoots.getGameRoot()) != ArchiveFsNodeType.DIRECTORY) {
            throw new IOException("Vice-City game root is not a real directory");
        }
        return inspectRelative(this.storageRoots.getGameRoot(), str);
    }

    private final File liveFile(String str) {
        File gameRoot = this.storageRoots.getGameRoot();
        for (String str2 : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
            gameRoot = new File(gameRoot, str2);
        }
        return gameRoot;
    }

    private final void validateArtifacts(List<ArchivePackageIdentity> list) {
        if (list.isEmpty()) {
            return;
        }
        for (ArchivePackageIdentity archivePackageIdentity : list) {
            artifactBytes(archivePackageIdentity);
        }
    }

    private final long artifactBytes(ArchivePackageIdentity archivePackageIdentity) {
        File archiveFile = ArchivePackagePaths.INSTANCE.archiveFile(this.storageRoots.getDownloadRoot(), archivePackageIdentity);
        File file = new File(archiveFile.getParentFile(), archiveFile.getName() + FileArchiveDownloadResumeStore.SIDECAR_SUFFIX);
        return addExact(addExact(addExact(exactArtifactFileBytes(this.storageRoots.getDownloadRoot(), archiveFile), exactArtifactFileBytes(this.storageRoots.getDownloadRoot(), file)), exactArtifactFileBytes(this.storageRoots.getDownloadRoot(), new File(file.getParentFile(), file.getName() + ".tmp"))), exactArtifactTreeBytes(this.storageRoots.getWorkRoot(), ArchivePackagePaths.INSTANCE.stagingRoot(this.storageRoots.getWorkRoot(), archivePackageIdentity)));
    }

    private final long exactArtifactFileBytes(File file, File file2) {
        if (requireDirectoryIfPresent(file, "Vice-City download root")) {
            int i = WhenMappings.$EnumSwitchMapping$0[inspectDescendant(file, file2).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        throw new IOException("Vice-City archive artifact is a directory: " + file2.getPath());
                    } else if (i == 4 || i == 5) {
                        throw new IOException("Vice-City archive artifact is unsafe: " + file2.getPath());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return RangesKt.coerceAtLeast(file2.length(), 0L);
            }
            return 0L;
        }
        return 0L;
    }

    private final long exactArtifactTreeBytes(File file, File file2) {
        if (requireDirectoryIfPresent(file, "Vice-City work root")) {
            int i = WhenMappings.$EnumSwitchMapping$0[inspectDescendant(file, file2).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new IOException("Vice-City staging root is a regular file: " + file2.getPath());
                } else if (i != 3) {
                    if (i == 4 || i == 5) {
                        throw new IOException("Vice-City staging root is unsafe: " + file2.getPath());
                    }
                    throw new NoWhenBranchMatchedException();
                } else {
                    return treeBytes(file2);
                }
            }
            return 0L;
        }
        return 0L;
    }

    private final long treeBytes(File file) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.nodeInspector.nodeType(file).ordinal()];
        long j = 0;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 || i == 5) {
                        throw new IOException("Vice-City staging tree contains an unsafe node: " + file.getPath());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException("Unable to list Vice-City staging directory: " + file.getPath());
                }
                for (File file2 : listFiles) {
                    File parentFile = file2.getParentFile();
                    if (!Intrinsics.areEqual(parentFile != null ? parentFile.getAbsoluteFile() : null, file.getAbsoluteFile())) {
                        throw new IOException("Vice-City staging directory returned an unsafe child");
                    }
                    Intrinsics.checkNotNull(file2);
                    j = addExact(j, treeBytes(file2));
                }
                return j;
            }
            return RangesKt.coerceAtLeast(file.length(), 0L);
        }
        return 0L;
    }

    private final ArchiveFsNodeType inspectRelative(File file, String str) {
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        for (Object obj : split$default) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            File file2 = new File(file, (String) obj);
            ArchiveFsNodeType nodeType = this.nodeInspector.nodeType(file2);
            int i3 = WhenMappings.$EnumSwitchMapping$0[nodeType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 || i3 == 5) {
                            throw new IOException("Vice-City path contains an unsafe node: " + str);
                        }
                        throw new NoWhenBranchMatchedException();
                    } else if (i != CollectionsKt.getLastIndex(split$default)) {
                        i = i2;
                        file = file2;
                    }
                } else if (i != CollectionsKt.getLastIndex(split$default)) {
                    throw new IOException("Vice-City path has a regular file parent: " + str);
                }
                return nodeType;
            }
            return ArchiveFsNodeType.ABSENT;
        }
        return ArchiveFsNodeType.ABSENT;
    }

    private final ArchiveFsNodeType inspectDescendant(File file, File file2) {
        File absoluteFile = file2.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File absoluteFile2 = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
        File relativeToOrNull = FilesKt.relativeToOrNull(absoluteFile, absoluteFile2);
        if (relativeToOrNull == null) {
            throw new IOException("Vice-City artifact escapes its scoped root: " + file2.getPath());
        }
        String path = relativeToOrNull.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        if (path.length() == 0) {
            return this.nodeInspector.nodeType(file);
        }
        String path2 = relativeToOrNull.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return inspectRelative(file, StringsKt.replace$default(path2, File.separatorChar, '/', false, 4, (Object) null));
    }

    private final void requireDirectory(File file, String str) {
        if (this.nodeInspector.nodeType(file) == ArchiveFsNodeType.DIRECTORY) {
            return;
        }
        throw new IOException(str + " is not a real directory: " + file.getPath());
    }

    private final boolean requireDirectoryIfPresent(File file, String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.nodeInspector.nodeType(file).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return true;
                }
                if (i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            throw new IOException(str + " is not a real directory: " + file.getPath());
        }
        return false;
    }

    private final long addExact(long j, long j2) {
        try {
            return Math.addExact(j, j2);
        } catch (ArithmeticException e) {
            throw new IOException("Vice-City content size overflows Long", e);
        }
    }

    private final String safeMessage(Exception exc) {
        String message = exc.getMessage();
        if (message == null) {
            String simpleName = exc.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            return simpleName;
        }
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface DeleteCompletion {

        /* compiled from: ViceCityArchiveContentManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Success implements DeleteCompletion {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 2117408372;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
            }
        }

        /* compiled from: ViceCityArchiveContentManager.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$DeleteCompletion;", UpdateServiceContract.BundleKey.DETAIL, "", "<init>", "(Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failure implements DeleteCompletion {
            public static final int $stable = 0;
            private final String detail;

            public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failure.detail;
                }
                return failure.copy(str);
            }

            public final String component1() {
                return this.detail;
            }

            public final Failure copy(String detail) {
                Intrinsics.checkNotNullParameter(detail, "detail");
                return new Failure(detail);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && Intrinsics.areEqual(this.detail, ((Failure) obj).detail);
            }

            public int hashCode() {
                return this.detail.hashCode();
            }

            public String toString() {
                return "Failure(detail=" + this.detail + ")";
            }

            public Failure(String detail) {
                Intrinsics.checkNotNullParameter(detail, "detail");
                this.detail = detail;
            }

            public final String getDetail() {
                return this.detail;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$ContentSnapshot;", "", "liveOwnership", "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "identities", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "stateTransactionId", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getLiveOwnership", "()Ljava/util/List;", "getIdentities", "getStateTransactionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ContentSnapshot {
        private final List<ArchivePackageIdentity> identities;
        private final List<ArchiveOwnedPath> liveOwnership;
        private final String stateTransactionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContentSnapshot copy$default(ContentSnapshot contentSnapshot, List list, List list2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = contentSnapshot.liveOwnership;
            }
            if ((i & 2) != 0) {
                list2 = contentSnapshot.identities;
            }
            if ((i & 4) != 0) {
                str = contentSnapshot.stateTransactionId;
            }
            return contentSnapshot.copy(list, list2, str);
        }

        public final List<ArchiveOwnedPath> component1() {
            return this.liveOwnership;
        }

        public final List<ArchivePackageIdentity> component2() {
            return this.identities;
        }

        public final String component3() {
            return this.stateTransactionId;
        }

        public final ContentSnapshot copy(List<ArchiveOwnedPath> liveOwnership, List<ArchivePackageIdentity> identities, String stateTransactionId) {
            Intrinsics.checkNotNullParameter(liveOwnership, "liveOwnership");
            Intrinsics.checkNotNullParameter(identities, "identities");
            Intrinsics.checkNotNullParameter(stateTransactionId, "stateTransactionId");
            return new ContentSnapshot(liveOwnership, identities, stateTransactionId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ContentSnapshot) {
                ContentSnapshot contentSnapshot = (ContentSnapshot) obj;
                return Intrinsics.areEqual(this.liveOwnership, contentSnapshot.liveOwnership) && Intrinsics.areEqual(this.identities, contentSnapshot.identities) && Intrinsics.areEqual(this.stateTransactionId, contentSnapshot.stateTransactionId);
            }
            return false;
        }

        public int hashCode() {
            return (((this.liveOwnership.hashCode() * 31) + this.identities.hashCode()) * 31) + this.stateTransactionId.hashCode();
        }

        public String toString() {
            List<ArchiveOwnedPath> list = this.liveOwnership;
            List<ArchivePackageIdentity> list2 = this.identities;
            return "ContentSnapshot(liveOwnership=" + list + ", identities=" + list2 + ", stateTransactionId=" + this.stateTransactionId + ")";
        }

        public ContentSnapshot(List<ArchiveOwnedPath> liveOwnership, List<ArchivePackageIdentity> identities, String stateTransactionId) {
            Intrinsics.checkNotNullParameter(liveOwnership, "liveOwnership");
            Intrinsics.checkNotNullParameter(identities, "identities");
            Intrinsics.checkNotNullParameter(stateTransactionId, "stateTransactionId");
            this.liveOwnership = liveOwnership;
            this.identities = identities;
            this.stateTransactionId = stateTransactionId;
        }

        public final List<ArchiveOwnedPath> getLiveOwnership() {
            return this.liveOwnership;
        }

        public final List<ArchivePackageIdentity> getIdentities() {
            return this.identities;
        }

        public final String getStateTransactionId() {
            return this.stateTransactionId;
        }
    }

    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager$Companion;", "", "<init>", "()V", "DELETE_TRANSACTION_ID", "", "PREFERENCES_NAME", "forAndroid", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentManager;", "context", "Landroid/content/Context;", "storageRoots", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ViceCityArchiveContentManager forAndroid$default(Companion companion, Context context, ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots, int i, Object obj) {
            if ((i & 2) != 0) {
                archiveUpdaterStorageRoots = null;
            }
            return companion.forAndroid(context, archiveUpdaterStorageRoots);
        }

        public final ViceCityArchiveContentManager forAndroid(Context context, ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            if (archiveUpdaterStorageRoots == null) {
                ArchiveDownloadRootResolver process = ArchiveDownloadRootResolver.Companion.getProcess();
                Intrinsics.checkNotNull(applicationContext);
                archiveUpdaterStorageRoots = process.resolve(applicationContext, ArchiveUpdaterStorageScope.VICE);
                if (archiveUpdaterStorageRoots == null) {
                    return null;
                }
            }
            ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots2 = archiveUpdaterStorageRoots;
            DurableArchiveStateStore forAndroid = DurableArchiveStateStore.Companion.forAndroid(archiveUpdaterStorageRoots2.getStateRoot());
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(ViceCityArchiveContentManager.PREFERENCES_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return new ViceCityArchiveContentManager(archiveUpdaterStorageRoots2, forAndroid, new AndroidViceCityArchiveDeleteMarker(sharedPreferences), null, null, null, 56, null);
        }
    }
}
