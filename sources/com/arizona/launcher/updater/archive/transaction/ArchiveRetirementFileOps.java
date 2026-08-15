package com.arizona.launcher.updater.archive.transaction;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementFileOps;", "", "nodeType", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "createDirectory", "", "directory", "atomicRename", "source", TypedValues.AttributesType.S_TARGET, "syncFile", "syncDirectory", "listChildren", "", "deleteRegularFile", "deleteEmptyDirectory", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRetirementFileOps {
    void atomicRename(File file, File file2) throws IOException;

    void createDirectory(File file) throws IOException;

    void deleteEmptyDirectory(File file) throws IOException;

    void deleteRegularFile(File file) throws IOException;

    List<File> listChildren(File file) throws IOException;

    ArchiveFsNodeType nodeType(File file) throws IOException;

    void syncDirectory(File file) throws IOException;

    void syncFile(File file) throws IOException;
}
