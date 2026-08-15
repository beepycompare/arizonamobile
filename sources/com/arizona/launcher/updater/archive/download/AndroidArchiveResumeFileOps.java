package com.arizona.launcher.updater.archive.download;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/AndroidArchiveResumeFileOps;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumeFileOps;", "<init>", "()V", "replaceAtomically", "", "source", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "syncDirectory", "directory", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AndroidArchiveResumeFileOps implements ArchiveResumeFileOps {
    public static final AndroidArchiveResumeFileOps INSTANCE = new AndroidArchiveResumeFileOps();

    private AndroidArchiveResumeFileOps() {
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveResumeFileOps
    public void replaceAtomically(File source, File target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Os.rename(source.getAbsolutePath(), target.getAbsolutePath());
        } catch (ErrnoException e) {
            String path = target.getPath();
            throw new IOException("Failed to atomically replace '" + path + "' from '" + source.getPath() + "'", e);
        }
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveResumeFileOps
    public void syncDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            FileDescriptor open = Os.open(directory.getAbsolutePath(), OsConstants.O_RDONLY, 0);
            try {
                try {
                    Os.fsync(open);
                    try {
                        Os.close(open);
                    } catch (ErrnoException unused) {
                    }
                } catch (ErrnoException e) {
                    throw new IOException("Unable to fsync resume sidecar directory", e);
                }
            } catch (Throwable th) {
                try {
                    Os.close(open);
                } catch (ErrnoException unused2) {
                }
                throw th;
            }
        } catch (ErrnoException e2) {
            throw new IOException("Unable to open resume sidecar directory for fsync", e2);
        }
    }
}
