package com.arizona.game;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import com.arizona.game.core.AdaptiveTriggers;
import com.arizona.game.core.JNIActivity;
import java.util.function.Consumer;
/* loaded from: classes3.dex */
public class natives {
    private static final int MAX_RESTARTS_IN_WINDOW = 2;
    private static final String RECOVERY_PREFS = "egl_context_recovery";
    private static final long RESTART_WINDOW_MS = 300000;
    private static final String TAG = "NativeEGL";

    public static native void GamepadGyroState(float f, float f2);

    public static native void GamepadMultiTouch(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void GamepadState(int i, float f, float f2, float f3, float f4, float f5, float f6, boolean z);

    public static native void GyroState(float f, float f2);

    public static native void Init(String str);

    public static native boolean IsGyroInputNeeded();

    public static native void KeyEvent(int i, int i2);

    public static native void MultiTouch(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void Pause();

    public static native void Resize(int i, int i2);

    public static native int RestoreUsbGamepadDriver(int i, int i2);

    public static native void Resume();

    public static native void SetFrameLimit(int i);

    public static native void SetGamepadGyroAvailable(boolean z);

    public static native void SetUsbGamepadActive(boolean z);

    public static native void Step();

    public static native void SurfaceCreated(Surface surface);

    public static native void SurfaceDestroyed();

    public static native void acknowledgeResourceOverlay(long j);

    public static native void completeResourceOverlaySync(String str);

    public static native void openResourceOverlayDetails();

    public static native String prepareResourceOverlay(String str, String str2);

    public static native void requestResourceOverlaySync();

    public static native void setResourceOverlaySyncHandler(Runnable runnable);

    public static native void setResourceOverlayUiHandler(Consumer<String> consumer);

    static {
        System.loadLibrary("ag-client");
    }

    public static void restartAfterGraphicsFailure() {
        JNIActivity context = JNIActivity.getContext();
        if (context == null) {
            Log.e(TAG, "Fatal EGL failure: game Activity is gone");
        } else {
            try {
                Context applicationContext = context.getApplicationContext();
                int i = 0;
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(RECOVERY_PREFS, 0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = sharedPreferences.getLong("last_restart", 0L);
                if (elapsedRealtime >= j && elapsedRealtime - j < 300000) {
                    i = sharedPreferences.getInt("attempts", 0);
                }
                if (i < 2) {
                    int i2 = i + 1;
                    if (sharedPreferences.edit().putLong("last_restart", elapsedRealtime).putInt("attempts", i2).commit()) {
                        Intent launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
                        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
                        if (launchIntentForPackage == null || alarmManager == null) {
                            Log.e(TAG, "Fatal EGL failure: no launcher intent or AlarmManager");
                        } else {
                            launchIntentForPackage.addFlags(268468224);
                            alarmManager.set(2, elapsedRealtime + 1000, PendingIntent.getActivity(applicationContext, 4540236, launchIntentForPackage, 335544320));
                            Log.e(TAG, "Fatal EGL failure: scheduled launcher restart (attempt " + i2 + ")");
                        }
                    }
                }
                Log.e(TAG, "Fatal EGL failure: restart limit reached or recovery state unavailable");
            } catch (RuntimeException e) {
                Log.e(TAG, "Unable to schedule launcher restart after EGL failure", e);
            }
        }
        AdaptiveTriggers.shutdown();
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
