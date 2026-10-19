package com.arizona.game.core;

import android.app.KeyguardManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.arizona.game.natives;
/* loaded from: classes3.dex */
public class JNIAppCompatActivity extends AppCompatActivity {
    private static JNIAppCompatActivity mContext;
    JNIGLSurfaceView mGLSurfaceView = null;
    protected FrameLayout mRootView = null;
    private boolean paused = false;
    private boolean hasFocus = false;
    private GyroInput gyroInput = null;
    boolean isFocused = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(7942);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        mContext = this;
        GyroInput gyroInput = new GyroInput(this);
        this.gyroInput = gyroInput;
        gyroInput.register();
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        hideSystemUI();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.arizona.game.core.JNIAppCompatActivity.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    JNIAppCompatActivity.this.hideSystemUI();
                }
            }
        });
        this.mGLSurfaceView = new JNIGLSurfaceView(this);
        FrameLayout frameLayout = new FrameLayout(this);
        this.mRootView = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRootView.addView(this.mGLSurfaceView);
        setContentView(this.mRootView);
        try {
            ((ConnectivityManager) getSystemService("connectivity")).setNetworkPreference(1);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        GyroInput gyroInput = this.gyroInput;
        if (gyroInput != null) {
            gyroInput.unregister();
        }
        super.onPause();
        this.paused = true;
        this.mGLSurfaceView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.paused = false;
        GyroInput gyroInput = this.gyroInput;
        if (gyroInput != null) {
            gyroInput.register();
        }
        this.mGLSurfaceView.onResume();
        hideSystemUI();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.hasFocus = z;
        if (!this.paused) {
            if (!z && this.isFocused) {
                runOnGLThread(new Runnable() { // from class: com.arizona.game.core.JNIAppCompatActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        natives.Pause();
                    }
                });
            } else if (z && !this.isFocused) {
                runOnGLThread(new Runnable() { // from class: com.arizona.game.core.JNIAppCompatActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        natives.Resume();
                    }
                });
            }
            this.isFocused = z;
        }
        if (z) {
            hideSystemUI();
        }
        resumeIfHasFocus();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < pointerCount; i7++) {
            int pointerId = motionEvent.getPointerId(i7);
            if (pointerId == 0) {
                i = (int) motionEvent.getX(i7);
                i2 = (int) motionEvent.getY(i7);
            } else if (pointerId == 1) {
                i3 = (int) motionEvent.getX(i7);
                i4 = (int) motionEvent.getY(i7);
            } else if (pointerId == 2) {
                i5 = (int) motionEvent.getX(i7);
                i6 = (int) motionEvent.getY(i7);
            }
        }
        natives.MultiTouch(motionEvent.getActionMasked(), motionEvent.getPointerId(motionEvent.getActionIndex()), i, i2, i3, i4, i5, i6);
        return super.onTouchEvent(motionEvent);
    }

    private boolean isDeviceLocked() {
        return ((KeyguardManager) getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    private boolean isDeviceAsleep() {
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return !powerManager.isInteractive();
    }

    private void resumeIfHasFocus() {
        boolean z = (isDeviceLocked() || isDeviceAsleep()) ? false : true;
        if (this.hasFocus && z) {
            this.mGLSurfaceView.onResume();
        }
    }

    public void runOnGLThread(Runnable runnable) {
        runnable.run();
    }

    public static JNIAppCompatActivity getContext() {
        return mContext;
    }

    public String getFullPath(String str) {
        return getExternalFilesDir(null).getAbsolutePath() + "/" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mGLSurfaceView = null;
        this.mRootView = null;
        mContext = null;
    }
}
