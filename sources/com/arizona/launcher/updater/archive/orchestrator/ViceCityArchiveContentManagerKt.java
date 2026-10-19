package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveRetirementResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViceCityArchiveContentManager.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"viceCityRetirementClient", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;", "gameRoot", "Ljava/io/File;", "workRoot", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViceCityArchiveContentManagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ArchiveRetirementClient viceCityRetirementClient(File file, File file2) {
        final ArchiveFileRetirement archiveFileRetirement = new ArchiveFileRetirement(file, null, file2, 2, null);
        return new ArchiveRetirementClient() { // from class: com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentManagerKt$viceCityRetirementClient$1
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
