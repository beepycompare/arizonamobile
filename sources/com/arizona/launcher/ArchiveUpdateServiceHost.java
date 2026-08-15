package com.arizona.launcher;

import androidx.media3.exoplayer.offline.DownloadService;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMetadataFinalizationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageRequirementsSnapshot;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\fH&J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0003H&J\n\u0010\"\u001a\u0004\u0018\u00010#H&J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H&J\u0018\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H¦@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0014\u0010-\u001a\u00020\f2\n\u0010.\u001a\u00060/j\u0002`0H&J\u0014\u00101\u001a\u00020\f2\n\u0010.\u001a\u00060/j\u0002`0H&J\b\u00102\u001a\u00020\fH&J\u0010\u00103\u001a\u00020\f2\u0006\u00104\u001a\u000205H&¨\u00066À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/ArchiveUpdateServiceHost;", "", "isArchiveServiceAlive", "", "activeUpdateOperation", "Lcom/arizona/launcher/UpdateOperationSnapshot;", "beginArchiveOperation", "", "()Ljava/lang/Long;", "isCurrentArchiveOperation", "token", "finishArchiveOperation", "", "onArchiveRequestCoalesced", "activeDownload", "activeOperationKind", "Lcom/arizona/launcher/UpdateOperationKind;", "onArchiveStartupCorrupt", "requestArchiveManifestRefresh", "reason", "", "warning", "setArchiveBenchmarkMode", UpdateActivity.UPDATE_MODE, "onArchiveDownloadSelected", "onArchiveNoWork", "hasEnoughSpaceForArchive", DownloadService.KEY_REQUIREMENTS, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "promoteArchiveForeground", "Lcom/arizona/launcher/ArchiveForegroundPromotion;", "beginArchiveProgress", "downloadBytes", "finalizationOnly", "createArchivePackageUpdater", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater;", "createArchiveMirrorCoordinator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator;", "operationToken", "finalizeArchiveMetadata", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expandArchiveRuntimeRequirements", "recordArchiveExecutionException", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "recordArchiveFinalizationException", "completeArchiveSuccess", "completeArchiveFailure", "failure", "Lcom/arizona/launcher/ArchiveServiceFailure;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveUpdateServiceHost {
    UpdateOperationSnapshot activeUpdateOperation();

    Long beginArchiveOperation();

    void beginArchiveProgress(long j, boolean z);

    void completeArchiveFailure(ArchiveServiceFailure archiveServiceFailure);

    void completeArchiveSuccess();

    ArchiveMirrorExecutionCoordinator createArchiveMirrorCoordinator(long j);

    ArchivePackageUpdater createArchivePackageUpdater();

    void expandArchiveRuntimeRequirements(ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot);

    Object finalizeArchiveMetadata(ArchiveManifest archiveManifest, Continuation<? super ArchiveMetadataFinalizationResult> continuation);

    void finishArchiveOperation(long j);

    boolean hasEnoughSpaceForArchive(ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot);

    boolean isArchiveServiceAlive();

    boolean isCurrentArchiveOperation(long j);

    void onArchiveDownloadSelected();

    void onArchiveNoWork();

    void onArchiveRequestCoalesced(boolean z, UpdateOperationKind updateOperationKind);

    void onArchiveStartupCorrupt();

    ArchiveForegroundPromotion promoteArchiveForeground();

    void recordArchiveExecutionException(Exception exc);

    void recordArchiveFinalizationException(Exception exc);

    void requestArchiveManifestRefresh(String str, boolean z);

    void setArchiveBenchmarkMode(String str);
}
