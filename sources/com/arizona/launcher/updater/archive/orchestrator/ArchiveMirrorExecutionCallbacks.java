package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.offline.DownloadService;
import kotlin.Metadata;
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J2\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCallbacks;", "", "onRemainingBytesFallback", "", "packageId", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onMirrorProgressReset", "remainingDownloadBytes", "", "onMirrorSelected", "server", "onPhase", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "onDownloadProgress", "downloadedBytes", "totalBytes", "onRuntimeRequirementsChanged", DownloadService.KEY_REQUIREMENTS, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "onRetry", "retryAttempt", "", "delayMs", "failureSubtype", "serverUrl", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveMirrorExecutionCallbacks {
    void onDownloadProgress(long j, long j2);

    void onMirrorProgressReset(long j);

    void onMirrorSelected(String str);

    void onPhase(ArchiveInstallerPhase archiveInstallerPhase, String str);

    void onRemainingBytesFallback(String str, Exception exc);

    void onRetry(String str, int i, long j, String str2, String str3);

    void onRuntimeRequirementsChanged(ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot);
}
