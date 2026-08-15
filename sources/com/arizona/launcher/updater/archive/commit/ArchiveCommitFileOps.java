package com.arizona.launcher.updater.archive.commit;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
/* compiled from: ArchiveCommitFileOps.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchiveCommitFileOps;", "", "atomicRename", "", "source", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "syncFile", UtilsKt.SCHEME_FILE, "syncDirectory", "directory", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveCommitFileOps {
    void atomicRename(File file, File file2) throws IOException;

    void syncDirectory(File file) throws IOException;

    void syncFile(File file) throws IOException;
}
