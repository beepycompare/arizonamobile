package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitResult;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.io.File;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class ArchivePackageUpdater$Companion$create$4 implements ArchiveCommitter, FunctionAdapter {
    final /* synthetic */ ArchivePackageCommitter $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchivePackageUpdater$Companion$create$4(ArchivePackageCommitter archivePackageCommitter) {
        this.$tmp0 = archivePackageCommitter;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ArchiveCommitter) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(3, this.$tmp0, ArchivePackageCommitter.class, "commit", "commit(Ljava/lang/String;Ljava/io/File;Ljava/util/List;)Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveCommitter
    public final ArchivePackageCommitResult commit(String p0, File p1, List<ArchivePackageFileRecord> p2) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        return this.$tmp0.commit(p0, p1, p2);
    }
}
