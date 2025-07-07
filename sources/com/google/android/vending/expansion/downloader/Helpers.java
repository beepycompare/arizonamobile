package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class Helpers {
    public static Random sRandom = new Random(SystemClock.uptimeMillis());
    public static String resourceClassString = "com.wardrumstudios.utils.R";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    private Helpers() {
    }

    public static int GetResourceIdentifier(Context context, String str, String str2) {
        Class<?> cls;
        try {
            Class<?>[] classes = Class.forName(resourceClassString).getClasses();
            int i = 0;
            while (true) {
                if (i >= classes.length) {
                    cls = null;
                    break;
                } else if (classes[i].getName().split("\\$")[1].equals(str2)) {
                    cls = classes[i];
                    break;
                } else {
                    i++;
                }
            }
            if (cls != null) {
                return cls.getField(str).getInt(cls);
            }
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return 0;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    static void deleteFile(String str) {
        try {
            new File(str).delete();
        } catch (Exception e) {
            Log.w(Constants.TAG, "file: '" + str + "' couldn't be deleted", e);
        }
    }

    public static boolean doesFileExist(Context context, String str, long j, boolean z) {
        File file = new File(generateSaveFileName(context, str));
        if (file.exists()) {
            if (file.length() == j) {
                return true;
            }
            if (z) {
                file.delete();
                return false;
            }
            return false;
        }
        return false;
    }

    public static String generateSaveFileName(Context context, String str) {
        return getSaveFilePath(context) + File.separator + str;
    }

    public static long getAvailableBytes(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    public static String getDownloadProgressPercent(long j, long j2) {
        return j2 == 0 ? "" : Long.toString((j * 100) / j2) + "%";
    }

    public static String getDownloadProgressString(long j, long j2) {
        return j2 == 0 ? "" : String.format("%.2f", Float.valueOf(((float) j) / 1048576.0f)) + "MB /" + String.format("%.2f", Float.valueOf(((float) j2) / 1048576.0f)) + "MB";
    }

    public static String getDownloadProgressStringNotification(long j, long j2) {
        return j2 == 0 ? "" : getDownloadProgressString(j, j2) + " (" + getDownloadProgressPercent(j, j2) + ")";
    }

    public static int getDownloaderStringResourceIDFromState(Context context, int i) {
        String str;
        switch (i) {
            case 1:
                str = "state_idle";
                break;
            case 2:
                str = "state_fetching_url";
                break;
            case 3:
                str = "state_connecting";
                break;
            case 4:
                str = "state_downloading";
                break;
            case 5:
                str = "state_completed";
                break;
            case 6:
                str = "state_paused_network_unavailable";
                break;
            case 7:
                str = "state_paused_by_request";
                break;
            case 8:
                return GetResourceIdentifier(context, "state_paused_wifi_disabled", TypedValues.Custom.S_STRING);
            case 9:
                return GetResourceIdentifier(context, "state_paused_wifi_unavailable", TypedValues.Custom.S_STRING);
            case 10:
                return GetResourceIdentifier(context, "state_paused_wifi_disabled", TypedValues.Custom.S_STRING);
            case 11:
                return GetResourceIdentifier(context, "state_paused_wifi_unavailable", TypedValues.Custom.S_STRING);
            case 12:
                str = "state_paused_roaming";
                break;
            case 13:
                str = "state_paused_network_setup_failure";
                break;
            case 14:
                str = "state_paused_sdcard_unavailable";
                break;
            case 15:
                str = "state_failed_unlicensed";
                break;
            case 16:
                str = "state_failed_fetching_url";
                break;
            case 17:
                str = "state_failed_sdcard_full";
                break;
            case 18:
                str = "state_failed_cancelled";
                break;
            default:
                str = "state_unknown";
                break;
        }
        return GetResourceIdentifier(context, str, TypedValues.Custom.S_STRING);
    }

    public static String getExpansionAPKFileName(Context context, boolean z, int i) {
        return (z ? "main." : "patch.") + i + "." + context.getPackageName() + ".obb";
    }

    public static File getFilesystemRoot(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for " + str);
    }

    public static String getSaveFilePath(Context context) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = Constants.EXP_PATH;
        System.out.println("getSaveFilePath " + externalStorageDirectory.toString() + str + context.getPackageName());
        return externalStorageDirectory.toString() + str + context.getPackageName();
    }

    public static String getSpeedString(float f) {
        return String.format("%.2f", Float.valueOf((f * 1000.0f) / 1024.0f));
    }

    public static String getTimeRemaining(long j) {
        return (j > 3600000 ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("mm:ss", Locale.getDefault())).format(new Date(j - TimeZone.getDefault().getRawOffset()));
    }

    public static boolean isExternalMediaMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isFilenameValid(String str) {
        String replaceFirst = str.replaceFirst("/+", RemoteSettings.FORWARD_SLASH_STRING);
        return replaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) || replaceFirst.startsWith(Environment.getExternalStorageDirectory().toString());
    }

    static String parseContentDisposition(String str) {
        try {
            Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
