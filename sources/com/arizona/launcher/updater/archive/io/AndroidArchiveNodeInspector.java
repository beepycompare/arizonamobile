package com.arizona.launcher.updater.archive.io;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveNodeInspector.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/AndroidArchiveNodeInspector;", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "()V", "nodeType", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveNodeInspector implements ArchiveNodeInspector {
    public static final int $stable = 0;
    public static final AndroidArchiveNodeInspector INSTANCE = new AndroidArchiveNodeInspector();

    private AndroidArchiveNodeInspector() {
    }

    @Override // com.arizona.launcher.updater.archive.io.ArchiveNodeInspector
    public ArchiveFsNodeType nodeType(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            StructStat lstat = Os.lstat(file.getAbsolutePath());
            return OsConstants.S_ISREG(lstat.st_mode) ? ArchiveFsNodeType.REGULAR_FILE : OsConstants.S_ISDIR(lstat.st_mode) ? ArchiveFsNodeType.DIRECTORY : OsConstants.S_ISLNK(lstat.st_mode) ? ArchiveFsNodeType.SYMBOLIC_LINK : ArchiveFsNodeType.OTHER;
        } catch (ErrnoException e) {
            if (e.errno == OsConstants.ENOENT) {
                return ArchiveFsNodeType.ABSENT;
            }
            throw new IOException("Unable to inspect archive path without following links", e);
        } catch (Exception e2) {
            throw new IOException("Unable to inspect archive path without following links", e2);
        }
    }
}
