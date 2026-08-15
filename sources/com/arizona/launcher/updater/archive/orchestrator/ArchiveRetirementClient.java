package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.transaction.ArchiveFileRetirement;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveRetirementResult;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;", "", "quarantine", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult;", "transactionId", "", ArchiveFileRetirement.TRASH_ROOT, "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "cleanup", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRetirementClient {
    ArchiveTrashCleanupResult cleanup(String str);

    ArchiveRetirementResult quarantine(String str, List<ArchiveOwnedPath> list);
}
