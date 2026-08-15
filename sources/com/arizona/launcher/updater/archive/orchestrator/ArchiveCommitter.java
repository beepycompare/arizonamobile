package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitResult;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCommitter;", "", "commit", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", "packageId", "", "stagingRoot", "Ljava/io/File;", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveCommitter {
    ArchivePackageCommitResult commit(String str, File file, List<ArchivePackageFileRecord> list);
}
