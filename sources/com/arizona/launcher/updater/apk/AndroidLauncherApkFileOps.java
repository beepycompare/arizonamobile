package com.arizona.launcher.updater.apk;

import android.system.Os;
import android.system.OsConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkFileOps.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/apk/AndroidLauncherApkFileOps;", "Lcom/arizona/launcher/updater/apk/LauncherApkFileOps;", "<init>", "()V", "atomicReplace", "", "source", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "syncFile", UtilsKt.SCHEME_FILE, "syncDirectory", "directory", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidLauncherApkFileOps implements LauncherApkFileOps {
    public static final int $stable = 0;
    public static final AndroidLauncherApkFileOps INSTANCE = new AndroidLauncherApkFileOps();

    private AndroidLauncherApkFileOps() {
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkFileOps
    public void atomicReplace(File source, File target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Os.rename(source.getAbsolutePath(), target.getAbsolutePath());
        } catch (Exception e) {
            throw new IOException("Unable to atomically replace launcher APK artifact", e);
        }
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkFileOps
    public void syncFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Exception e) {
            throw new IOException("Unable to sync launcher APK artifact", e);
        }
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkFileOps
    public void syncDirectory(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        FileDescriptor fileDescriptor = null;
        try {
            try {
                fileDescriptor = Os.open(directory.getAbsolutePath(), OsConstants.O_RDONLY, 0);
                Os.fsync(fileDescriptor);
                if (fileDescriptor != null) {
                    try {
                        Os.close(fileDescriptor);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                throw new IOException("Unable to sync launcher APK directory", e);
            }
        } catch (Throwable th) {
            if (fileDescriptor != null) {
                try {
                    Os.close(fileDescriptor);
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
