package com.arizona.launcher.updater.archive.download;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/JvmArchiveResumeFileOps;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumeFileOps;", "<init>", "()V", "replaceAtomically", "", "source", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "syncDirectory", "directory", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JvmArchiveResumeFileOps implements ArchiveResumeFileOps {
    public static final JvmArchiveResumeFileOps INSTANCE = new JvmArchiveResumeFileOps();

    private JvmArchiveResumeFileOps() {
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveResumeFileOps
    public void replaceAtomically(File source, File target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Files.move(source.toPath(), target.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException unused) {
            Files.move(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveResumeFileOps
    public void syncDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            FileChannel open = FileChannel.open(directory.toPath(), StandardOpenOption.READ);
            open.force(true);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(open, null);
        } catch (IOException | UnsupportedOperationException unused) {
        }
    }
}
