package com.arizona.launcher.updater.archive.commit;

import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitResult;
import kotlin.Metadata;
/* compiled from: ArchivePackageCommitter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u0006"}, d2 = {"failure", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitErrorCode;", "relativePath", "", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageCommitterKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArchivePackageCommitResult.Failure failure$default(ArchivePackageCommitErrorCode archivePackageCommitErrorCode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return failure(archivePackageCommitErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArchivePackageCommitResult.Failure failure(ArchivePackageCommitErrorCode archivePackageCommitErrorCode, String str) {
        return new ArchivePackageCommitResult.Failure(archivePackageCommitErrorCode, str);
    }
}
