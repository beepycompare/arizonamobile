package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import kotlin.Metadata;
/* compiled from: FileCheckServiceFlow.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0014\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/FileCheckServiceHost;", "", "beginFileCheckOperation", "", "()Ljava/lang/Long;", "isCurrentFileCheckOperation", "", "token", "finishFileCheckOperation", "onFileCheckAuditFailure", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fallback", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Unavailable;", "onFileCheckRepairScheduled", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$RepairScheduled;", "markFileCheckRecoveryRequired", "markGameUpdateRequiredAfterFileCheck", "completeFullFileCheck", "status", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FileCheckServiceHost {
    Long beginFileCheckOperation();

    void completeFullFileCheck(boolean z);

    boolean finishFileCheckOperation(long j);

    boolean isCurrentFileCheckOperation(long j);

    void markFileCheckRecoveryRequired();

    void markGameUpdateRequiredAfterFileCheck();

    void onFileCheckAuditFailure(Exception exc, ArchivePayloadAuditResult.Unavailable unavailable);

    void onFileCheckRepairScheduled(ArchivePayloadAuditResult.RepairScheduled repairScheduled);
}
