package com.arizona.launcher.updater.archive.transaction;

import android.system.Os;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.commit.AndroidArchiveCommitFileOps;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/AndroidArchiveRetirementFileOps;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementFileOps;", "<init>", "()V", "nodeType", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "createDirectory", "", "directory", "atomicRename", "source", TypedValues.AttributesType.S_TARGET, "syncFile", "syncDirectory", "listChildren", "", "deleteRegularFile", "deleteEmptyDirectory", "DIRECTORY_MODE", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveRetirementFileOps implements ArchiveRetirementFileOps {
    public static final int $stable = 0;
    private static final int DIRECTORY_MODE = 448;
    public static final AndroidArchiveRetirementFileOps INSTANCE = new AndroidArchiveRetirementFileOps();

    private AndroidArchiveRetirementFileOps() {
    }

    @Override // com.arizona.launcher.updater.archive.io.ArchiveNodeInspector
    public ArchiveFsNodeType nodeType(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return AndroidArchiveNodeInspector.INSTANCE.nodeType(file);
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void createDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            Os.mkdir(directory.getAbsolutePath(), DIRECTORY_MODE);
        } catch (Exception e) {
            throw new IOException("Unable to create archive retirement directory", e);
        }
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void atomicRename(File source, File target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Os.rename(source.getAbsolutePath(), target.getAbsolutePath());
        } catch (Exception e) {
            throw new IOException("Unable to quarantine retired archive file", e);
        }
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void syncFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        AndroidArchiveCommitFileOps.INSTANCE.syncFile(file);
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void syncDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        AndroidArchiveCommitFileOps.INSTANCE.syncDirectory(directory);
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public List<File> listChildren(File directory) {
        List<File> list;
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            File[] listFiles = directory.listFiles();
            if (listFiles == null || (list = ArraysKt.toList(listFiles)) == null) {
                throw new IOException("Unable to list archive retirement directory");
            }
            return list;
        } catch (SecurityException e) {
            throw new IOException("Unable to list archive retirement directory", e);
        }
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void deleteRegularFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            if (!file.delete() && file.exists()) {
                throw new IOException("Unable to delete quarantined archive file");
            }
        } catch (Exception e) {
            throw new IOException("Unable to delete quarantined archive file", e);
        }
    }

    @Override // com.arizona.launcher.updater.archive.transaction.ArchiveRetirementFileOps
    public void deleteEmptyDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            if (!directory.delete() && directory.exists()) {
                throw new IOException("Unable to delete archive retirement directory");
            }
        } catch (Exception e) {
            throw new IOException("Unable to delete archive retirement directory", e);
        }
    }
}
