package com.arizona.launcher.updater.archive.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDirectoryCreator.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/JvmArchiveDirectoryCreator;", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "()V", "createDirectories", "", "directory", "Ljava/io/File;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JvmArchiveDirectoryCreator implements ArchiveDirectoryCreator {
    public static final int $stable = 0;
    public static final JvmArchiveDirectoryCreator INSTANCE = new JvmArchiveDirectoryCreator();

    private JvmArchiveDirectoryCreator() {
    }

    @Override // com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator
    public boolean createDirectories(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        return directory.isDirectory() || directory.mkdirs();
    }
}
