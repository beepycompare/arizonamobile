package com.arizona.game;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.vending.expansion.downloader.Helpers;
import com.wardrumstudios.utils.WarDownloaderService;
import com.wardrumstudios.utils.WarMedia;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class GTASAInternal extends WarMedia {
    private static final int LEGACY_TOTAL_MEMORY_MB = 256;
    private static final String TAG = "GTASAInternal";
    static boolean UseAndroidHal = false;
    static String vmVersion;
    boolean IsAmazonBuild = false;
    boolean UseExpansionPack = true;
    public boolean isInSocialClub = true;

    @Override // com.wardrumstudios.utils.WarMedia
    protected boolean localHasGameData() {
        AfterDownloadFunction();
        return true;
    }

    static {
        System.out.println("**** Loading SO's");
        try {
            vmVersion = System.getProperty("java.vm.version");
            System.out.println("vmVersion " + vmVersion);
            String str = Build.CPU_ABI;
            boolean is64Bit = Process.is64Bit();
            System.out.println("Abi: " + str + ", supported ABIs: " + Arrays.toString(Build.SUPPORTED_ABIS) + ", is64BitProcess: " + is64Bit + " was loaded!");
            if (is64Bit) {
                System.loadLibrary("SCAnd");
            } else {
                System.loadLibrary("ImmEmulatorJ");
            }
            System.loadLibrary("GTASA");
            System.loadLibrary("samp");
            if (is64Bit) {
                System.loadLibrary("bass");
                System.loadLibrary("bass_fx");
                System.loadLibrary("bass_ssl");
            }
        } catch (RuntimeException e) {
            Log.d(TAG, e.toString());
        }
    }

    @Override // com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, android.app.Activity
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        try {
            return super.dispatchKeyEvent(event);
        } catch (NullPointerException e) {
            if (this.isWarGamepadNullDeviceCrash(e, event)) {
                Log.w(TAG, "Dropped key event without InputDevice to avoid WarGamepad crash: keyCode=" + event.getKeyCode() + ", action=" + event.getAction() + ", source=" + event.getSource(), e);
                return true;
            }
            throw e;
        }
    }

    private boolean isWarGamepadNullDeviceCrash(NullPointerException e, KeyEvent event) {
        if (event != null && event.getDevice() == null) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if ("com.wardrumstudios.utils.WarGamepad".equals(stackTraceElement.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.wardrumstudios.utils.WarMedia
    public int GetMemoryInfo(boolean refreshRunningProcesses) {
        int[] warMediaIntArrayField;
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            Log.w(TAG, "GetMemoryInfo: ActivityManager is unavailable");
            return getWarMediaIntField("availableMemory", 0);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i = (int) ((memoryInfo.availMem / 1024) / 1024);
        int i2 = (int) (memoryInfo.threshold / 1024);
        setWarMediaField("mgr", activityManager);
        setWarMediaField("memInfo", memoryInfo);
        setWarMediaField("memoryThreshold", Integer.valueOf(i2));
        setWarMediaField("availableMemory", Integer.valueOf(i));
        setWarMediaField("totalMemory", Integer.valueOf((int) ((memoryInfo.totalMem / 1024) / 1024)));
        if (refreshRunningProcesses) {
            warMediaIntArrayField = getRunningProcessIds(activityManager);
        } else {
            warMediaIntArrayField = getWarMediaIntArrayField("myPid");
        }
        if (warMediaIntArrayField != null && warMediaIntArrayField.length > 0) {
            setWarMediaField("myPid", warMediaIntArrayField);
            try {
                activityManager.getProcessMemoryInfo(warMediaIntArrayField);
                return i;
            } catch (RuntimeException e) {
                Log.w(TAG, "GetMemoryInfo: unable to query process memory info", e);
            }
        }
        return i;
    }

    private int[] getRunningProcessIds(ActivityManager activityManager) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                return new int[]{Process.myPid()};
            }
            int[] iArr = new int[runningAppProcesses.size()];
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                iArr[i] = runningAppProcesses.get(i).pid;
            }
            return iArr;
        } catch (RuntimeException e) {
            Log.w(TAG, "GetMemoryInfo: unable to read running processes", e);
            return new int[]{Process.myPid()};
        }
    }

    private int[] getWarMediaIntArrayField(String fieldName) {
        Object warMediaField = getWarMediaField(fieldName);
        if (warMediaField instanceof int[]) {
            return (int[]) warMediaField;
        }
        return null;
    }

    private int getWarMediaIntField(String fieldName, int defaultValue) {
        Object warMediaField = getWarMediaField(fieldName);
        return warMediaField instanceof Integer ? ((Integer) warMediaField).intValue() : defaultValue;
    }

    private Object getWarMediaField(String fieldName) {
        try {
            Field declaredField = WarMedia.class.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField.get(this);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Log.w(TAG, "Unable to read WarMedia field: " + fieldName, e);
            return null;
        }
    }

    private void setWarMediaField(String fieldName, Object value) {
        try {
            Field declaredField = WarMedia.class.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(this, value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Log.w(TAG, "Unable to update WarMedia field: " + fieldName, e);
        }
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarGamepad, com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle paramBundle) {
        System.out.println("Build Type: release");
        System.out.println("Version: v17.2.0");
        this.HELLO_ID = 123324;
        this.appIntent = new Intent(this, GTASA.class);
        this.appTickerText = "GTA3 San Andreas";
        this.appContentTitle = "San Andreas";
        this.appContentText = "Running - Return to Game?";
        Helpers.resourceClassString = "com.arizona.game.R";
        this.expansionFileName = "main.8.com.arizona.game.obb";
        this.patchFileName = "patch.8.com.arizona.game.obb";
        this.apkFileName = GetPackageName("com.arizona.game");
        this.baseDirectory = GetGameBaseDirectory();
        this.AllowLongPressForExit = true;
        String str = Environment.getExternalStorageDirectory() + "/GTASA/";
        File file = new File(str + this.expansionFileName);
        if (!this.IsAmazonBuild && file.exists()) {
            this.UseExpansionPack = false;
            this.baseDirectory = str;
        }
        if (this.IsAmazonBuild) {
            this.UseExpansionPack = false;
        }
        WarDownloaderService.BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlDfyMGss+/15UlnoCk+/NWLga5rXTgJyt893tWIPAkSNawLOHC8pFzuKZ26ZxGKUB88+6kfXVHBryUb3pDWItMj9qbDm+6Guu3mDx+r9TmSDEN8olB2egFSeosjWT4wvFu/couZumEGKgAqcIl82LIfblyGmkh9zzgyf3MSQnQdUbtIpC4uoYs51f9jEalFrtAWb7gGrPFKbMydRZgADO+Uon1w9Q+Zv5Jmtgg0YpA1hxQRf9eEidlz1Rry1U+/HtfZH7oHKIiDFm+7EmRwX4qacxVr/xdM5AUvI5GMgij37i+eAxQAq267mRDOy3UZc42odygjvGqL8ln9+cUfudwIDAQAB";
        WarDownloaderService.SALT = new byte[]{1, 42, -12, -1, 54, 98, -100, -12, 43, 2, -8, -4, 9, 5, -106, -107, -33, 45, -1, 84};
        if (this.UseExpansionPack) {
            this.xAPKS = new WarMedia.XAPKFile[2];
            this.xAPKS[0] = new WarMedia.XAPKFile(true, 8, 1967561852L);
            this.xAPKS[1] = new WarMedia.XAPKFile(false, 8, 625313014L);
        }
        this.AddMovieExtension = false;
        this.wantsMultitouch = true;
        this.wantsAccelerometer = true;
        RestoreCurrentLanguage();
        boolean z = UseAndroidHal && !IsTV();
        UseAndroidHal = z;
        if (z) {
            this.delaySetContentView = true;
        }
        super.onCreate(paramBundle);
        SetReportPS3As360(false);
        if (UseAndroidHal) {
            return;
        }
        this.isInSocialClub = false;
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarGamepad, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < pointerCount; i9++) {
            int pointerId = event.getPointerId(i9);
            if (pointerId == 0) {
                i2 = (int) event.getY(i9);
                i = (int) event.getX(i9);
            } else if (pointerId == 1) {
                i4 = (int) event.getY(i9);
                i3 = (int) event.getX(i9);
            } else if (pointerId == 2) {
                i6 = (int) event.getY(i9);
                i5 = (int) event.getX(i9);
            } else if (pointerId == 3) {
                i8 = (int) event.getY(i9);
                i7 = (int) event.getX(i9);
            }
        }
        multiTouchEvent4(event.getActionMasked(), event.getPointerId(event.getActionIndex()), i, i2, i3, i4, i5, i6, i7, i8, event);
        return true;
    }
}
