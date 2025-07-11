package io.appmetrica.analytics.coreutils.internal.io;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\u0013*\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\u0013*\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0016\u001a\u00020\u0013*\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0017\u001a\u00020\u0013*\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/io/FileUtils;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "sdkStorage", "getAppStorageDirectory", "", "fileName", "getFileFromSdkStorage", "getFileFromAppStorage", "getCrashesDirectory", "getNativeCrashDirectory", "filePath", "getFileFromPath", "getAppDataDir", "", "resetSdkStorage", TypedValues.TransitionType.S_TO, "", "move", "copyToNullable", "moveByCopy", "moveByRename", "SDK_STORAGE_RELATIVE_PATH", "Ljava/lang/String;", "SDK_FILES_PREFIX", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();
    public static final String SDK_FILES_PREFIX = "appmetrica_analytics";
    public static final String SDK_STORAGE_RELATIVE_PATH = "/appmetrica/analytics";

    /* renamed from: a  reason: collision with root package name */
    private static volatile File f274a;

    private FileUtils() {
    }

    @JvmStatic
    public static final boolean copyToNullable(File file, File file2) {
        if (file != null && file2 != null && file.exists()) {
            try {
                FilesKt.copyTo$default(file, file2, false, 0, 6, null);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @JvmStatic
    public static final File getAppDataDir(Context context) {
        if (AndroidUtils.isApiAchieved(24)) {
            return AppDataDirProviderForN.INSTANCE.dataDir(context);
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getParentFile();
        }
        return null;
    }

    @JvmStatic
    public static final File getAppStorageDirectory(Context context) {
        return context.getNoBackupFilesDir();
    }

    @JvmStatic
    public static final File getCrashesDirectory(Context context) {
        return getFileFromSdkStorage(context, "crashes");
    }

    @JvmStatic
    public static final File getFileFromAppStorage(Context context, String str) {
        File appStorageDirectory = getAppStorageDirectory(context);
        if (appStorageDirectory != null) {
            return new File(appStorageDirectory, str);
        }
        return null;
    }

    @JvmStatic
    public static final File getFileFromPath(String str) {
        return new File(str);
    }

    @JvmStatic
    public static final File getFileFromSdkStorage(Context context, String str) {
        File sdkStorage = sdkStorage(context);
        if (sdkStorage != null) {
            return new File(sdkStorage, str);
        }
        return null;
    }

    @JvmStatic
    public static final File getNativeCrashDirectory(Context context) {
        return getFileFromSdkStorage(context, "native_crashes");
    }

    @JvmStatic
    public static final boolean move(File file, File file2) {
        FileUtils fileUtils = INSTANCE;
        return fileUtils.moveByRename(file, file2) || fileUtils.moveByCopy(file, file2);
    }

    @JvmStatic
    public static final void resetSdkStorage() {
        synchronized (INSTANCE) {
            f274a = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final File sdkStorage(Context context) {
        File file;
        if (f274a == null) {
            FileUtils fileUtils = INSTANCE;
            synchronized (fileUtils) {
                File appStorageDirectory = getAppStorageDirectory(context);
                fileUtils.getClass();
                if (appStorageDirectory == null) {
                    file = null;
                } else {
                    File file2 = new File(appStorageDirectory, SDK_STORAGE_RELATIVE_PATH);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = file2;
                }
                f274a = file;
                Unit unit = Unit.INSTANCE;
            }
        }
        return f274a;
    }

    public final boolean moveByCopy(File file, File file2) {
        if (file != null && file2 != null && file.exists()) {
            try {
                FilesKt.copyTo$default(file, file2, false, 0, 6, null);
                file.delete();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final boolean moveByRename(File file, File file2) {
        if (file2 != null) {
            Boolean valueOf = file != null ? Boolean.valueOf(file.renameTo(file2)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
            return false;
        }
        return false;
    }
}
