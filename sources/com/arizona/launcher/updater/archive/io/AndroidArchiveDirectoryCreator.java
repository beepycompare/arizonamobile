package com.arizona.launcher.updater.archive.io;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDirectoryCreator.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/AndroidArchiveDirectoryCreator;", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "()V", "createDirectories", "", "directory", "Ljava/io/File;", "DIRECTORY_MODE", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveDirectoryCreator implements ArchiveDirectoryCreator {
    public static final int $stable = 0;
    private static final int DIRECTORY_MODE = 448;
    public static final AndroidArchiveDirectoryCreator INSTANCE = new AndroidArchiveDirectoryCreator();

    private AndroidArchiveDirectoryCreator() {
    }

    @Override // com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator
    public boolean createDirectories(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        if (directory.isDirectory()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        File absoluteFile = directory.getAbsoluteFile();
        while (absoluteFile != null && !absoluteFile.exists()) {
            arrayList.add(absoluteFile);
            absoluteFile = absoluteFile.getParentFile();
        }
        if (absoluteFile == null || !absoluteFile.isDirectory()) {
            return false;
        }
        for (File file : CollectionsKt.asReversedMutable(arrayList)) {
            try {
                Os.mkdir(file.getAbsolutePath(), DIRECTORY_MODE);
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.EEXIST || !file.isDirectory()) {
                    throw new IOException("Unable to create archive directory", e);
                }
            } catch (SecurityException e2) {
                throw new IOException("Unable to create archive directory", e2);
            }
        }
        return directory.isDirectory();
    }
}
