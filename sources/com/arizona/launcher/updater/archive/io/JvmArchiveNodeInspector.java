package com.arizona.launcher.updater.archive.io;

import coil3.util.UtilsKt;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveNodeInspector.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/JvmArchiveNodeInspector;", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "()V", "nodeType", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmArchiveNodeInspector implements ArchiveNodeInspector {
    public static final int $stable = 0;
    public static final JvmArchiveNodeInspector INSTANCE = new JvmArchiveNodeInspector();

    private JvmArchiveNodeInspector() {
    }

    @Override // com.arizona.launcher.updater.archive.io.ArchiveNodeInspector
    public ArchiveFsNodeType nodeType(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            return readAttributes.isSymbolicLink() ? ArchiveFsNodeType.SYMBOLIC_LINK : readAttributes.isRegularFile() ? ArchiveFsNodeType.REGULAR_FILE : readAttributes.isDirectory() ? ArchiveFsNodeType.DIRECTORY : ArchiveFsNodeType.OTHER;
        } catch (NoSuchFileException unused) {
            return ArchiveFsNodeType.ABSENT;
        }
    }
}
