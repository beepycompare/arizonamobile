package com.wardrumstudios.utils;

import android.app.NativeActivity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes4.dex */
public class NDKHelper {
    private static boolean loadedSO = false;
    NativeActivity activity;

    public NDKHelper(NativeActivity nativeActivity) {
        this.activity = nativeActivity;
    }

    public static Boolean checkSOLoaded() {
        boolean z;
        if (loadedSO) {
            z = true;
        } else {
            Log.e("NDKHelper", "--------------------------------------------\n.so has not been loaded. To use JUI helper, please initialize with \nNDKHelper::Init( ANativeActivity* activity, const char* helper_class_name, const char* native_soname);\n--------------------------------------------\n");
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private int nextPOT(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2;
    }

    private Bitmap scaleBitmap(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f / width, f2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public native void RunOnUiThreadHandler(long j);

    public void closeBitmap(Bitmap bitmap) {
        bitmap.recycle();
    }

    public String getApplicationName() {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = this.activity.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    public int getBitmapHeight(Bitmap bitmap) {
        return bitmap.getHeight();
    }

    public void getBitmapPixels(Bitmap bitmap, int[] iArr) {
        int width = bitmap.getWidth();
        bitmap.getPixels(iArr, 0, width, 0, 0, width, bitmap.getHeight());
    }

    public int getBitmapWidth(Bitmap bitmap) {
        return bitmap.getWidth();
    }

    public int getNativeAudioBufferSize() {
        return Integer.parseInt(((AudioManager) this.activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
    }

    public int getNativeAudioSampleRate() {
        return AudioTrack.getNativeOutputSampleRate(1);
    }

    public String getNativeLibraryDirectory(Context context) {
        ApplicationInfo applicationInfo = this.activity.getApplicationInfo();
        Log.w("NDKHelper", "ai.nativeLibraryDir:" + applicationInfo.nativeLibraryDir);
        return ((applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    public void loadLibrary(String str) {
        if (str.isEmpty()) {
            return;
        }
        System.loadLibrary(str);
        loadedSO = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.graphics.Bitmap] */
    public boolean loadTexture(String str) {
        try {
            File file = new File(this.activity.getExternalFilesDir(null), !str.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? RemoteSettings.FORWARD_SLASH_STRING + str : str);
            str = BitmapFactory.decodeStream(file.canRead() ? new FileInputStream(file) : this.activity.getResources().getAssets().open(str));
            if (str != 0) {
                GLUtils.texImage2D(3553, 0, str, 0);
                return true;
            }
            return true;
        } catch (Exception unused) {
            Log.w("NDKHelper", "Coundn't load a file:" + str);
            return false;
        }
    }

    public Bitmap openBitmap(String str, boolean z) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(this.activity.getResources().getAssets().open(str));
            if (z) {
                int bitmapWidth = getBitmapWidth(bitmap);
                int bitmapHeight = getBitmapHeight(bitmap);
                int nextPOT = nextPOT(bitmapWidth);
                int nextPOT2 = nextPOT(bitmapHeight);
                if (bitmapWidth != nextPOT || bitmapHeight != nextPOT2) {
                    return scaleBitmap(bitmap, nextPOT, nextPOT2);
                }
            }
            return bitmap;
        } catch (Exception unused) {
            Log.w("NDKHelper", "Coundn't load a file:" + str);
            return bitmap;
        }
    }

    public void runOnUIThread(final long j) {
        if (checkSOLoaded().booleanValue()) {
            this.activity.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.NDKHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    NDKHelper.this.RunOnUiThreadHandler(j);
                }
            });
        }
    }
}
