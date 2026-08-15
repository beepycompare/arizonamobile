package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveRetirementResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\n\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "packageId", "", "detail", "runtimeDownloadBytes", "", "runtimeRequiredFreeSpaceBytes", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "archiveRetirementClient", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;", "gameRoot", "Ljava/io/File;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageUpdaterKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArchiveUpdaterResult.Failure failure$default(ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, String str2, Long l, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        if ((i & 16) != 0) {
            l2 = null;
        }
        return failure(archiveUpdaterErrorCode, str, str2, l, l2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArchiveUpdaterResult.Failure failure(ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, String str2, Long l, Long l2) {
        return new ArchiveUpdaterResult.Failure(archiveUpdaterErrorCode, str, str2, null, null, l, l2, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArchiveRetirementClient archiveRetirementClient(File file) {
        final ArchiveFileRetirement archiveFileRetirement = new ArchiveFileRetirement(file, null, 2, null);
        return new ArchiveRetirementClient() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdaterKt$archiveRetirementClient$1
            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRetirementClient
            public ArchiveRetirementResult quarantine(String transactionId, List<ArchiveOwnedPath> retired) {
                Intrinsics.checkNotNullParameter(transactionId, "transactionId");
                Intrinsics.checkNotNullParameter(retired, "retired");
                return ArchiveFileRetirement.this.quarantine(transactionId, retired);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRetirementClient
            public ArchiveTrashCleanupResult cleanup(String transactionId) {
                Intrinsics.checkNotNullParameter(transactionId, "transactionId");
                return ArchiveFileRetirement.this.cleanupTrash(transactionId);
            }
        };
    }
}
