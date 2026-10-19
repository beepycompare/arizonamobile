package com.arizona.game.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.arizona.game.natives;
/* loaded from: classes3.dex */
public class JNIActivity extends Activity {
    private static volatile JNIActivity mContext;
    private boolean dispatchingGamepadTouch;
    private boolean gamepadNativeFallbackAllowed;
    private boolean gamepadTouchForwardedToNative;
    JNIGLSurfaceView mGLSurfaceView = null;
    protected FrameLayout mRootView = null;
    private boolean paused = false;
    private boolean hasFocus = false;
    private final GamepadInput gamepadInput = new GamepadInput();
    private GyroInput gyroInput = null;
    boolean isFocused = false;

    protected boolean deferGameSurfaceCreation() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(7942);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        mContext = this;
        AdaptiveTriggers.register(this);
        this.gamepadInput.register(this);
        GyroInput gyroInput = new GyroInput(this);
        this.gyroInput = gyroInput;
        gyroInput.register();
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        hideSystemUI();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.arizona.game.core.JNIActivity.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    JNIActivity.this.hideSystemUI();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this);
        this.mRootView = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.mRootView);
        if (!deferGameSurfaceCreation()) {
            startGameSurface();
        }
        try {
            ((ConnectivityManager) getSystemService("connectivity")).setNetworkPreference(1);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void startGameSurface() {
        if (this.mGLSurfaceView != null || this.mRootView == null || isFinishing() || isDestroyed()) {
            return;
        }
        JNIGLSurfaceView jNIGLSurfaceView = new JNIGLSurfaceView(this);
        this.mGLSurfaceView = jNIGLSurfaceView;
        this.mRootView.addView(jNIGLSurfaceView, 0);
        boolean z = this.paused;
        JNIGLSurfaceView jNIGLSurfaceView2 = this.mGLSurfaceView;
        if (z) {
            jNIGLSurfaceView2.onPause();
        } else {
            jNIGLSurfaceView2.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        AdaptiveTriggers.setForeground(false);
        this.gamepadInput.reset();
        GyroInput gyroInput = this.gyroInput;
        if (gyroInput != null) {
            gyroInput.unregister();
        }
        super.onPause();
        this.paused = true;
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView != null) {
            jNIGLSurfaceView.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.paused = false;
        AdaptiveTriggers.setForeground(this.hasFocus);
        GyroInput gyroInput = this.gyroInput;
        if (gyroInput != null) {
            gyroInput.register();
        }
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView != null) {
            jNIGLSurfaceView.onResume();
        }
        hideSystemUI();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.i("NativeEGL", "Game configuration changed: " + configuration.screenWidthDp + "x" + configuration.screenHeightDp + "dp, density=" + configuration.densityDpi);
        hideSystemUI();
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView != null) {
            jNIGLSurfaceView.post(new Runnable() { // from class: com.arizona.game.core.JNIActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JNIActivity.this.lambda$onConfigurationChanged$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$0() {
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView != null) {
            jNIGLSurfaceView.onDisplayConfigurationChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        AdaptiveTriggers.setForeground(z && !this.paused);
        if (!z) {
            this.gamepadInput.reset();
        }
        super.onWindowFocusChanged(z);
        this.hasFocus = z;
        if (!this.paused && this.mGLSurfaceView != null) {
            if (!z && this.isFocused) {
                runOnGLThread(new Runnable() { // from class: com.arizona.game.core.JNIActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        natives.Pause();
                    }
                });
            } else if (z && !this.isFocused) {
                runOnGLThread(new Runnable() { // from class: com.arizona.game.core.JNIActivity.3
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

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView == null || !jNIGLSurfaceView.isInitialized()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.paused && this.hasFocus && this.gamepadInput.onKeyEvent(keyEvent)) {
            return true;
        }
        boolean isControllerKey = GamepadInput.isControllerKey(keyEvent);
        int action = keyEvent.getAction();
        if (!isControllerKey && action == 0 && keyEvent.getRepeatCount() == 0) {
            natives.KeyEvent(keyEvent.getKeyCode(), 1);
        } else if (!isControllerKey && action == 1) {
            natives.KeyEvent(keyEvent.getKeyCode(), 0);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!this.paused && this.hasFocus && this.gamepadInput.onMotionEvent(motionEvent)) {
            return true;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dispatchingGamepadTouch && !this.paused && this.hasFocus) {
            this.gamepadInput.observeTouchpadEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void passTouchEventToCpp(MotionEvent motionEvent) {
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView == null || !jNIGLSurfaceView.isInitialized()) {
            return;
        }
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
        int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        if (this.dispatchingGamepadTouch) {
            if (motionEvent.findPointerIndex(0) >= 0) {
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
            }
            if (motionEvent.findPointerIndex(1) >= 0) {
                i3 = Math.max(1, i3);
                i4 = Math.max(1, i4);
            }
            if (motionEvent.findPointerIndex(2) >= 0) {
                i5 = Math.max(1, i5);
                i6 = Math.max(1, i6);
            }
        }
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        if (this.dispatchingGamepadTouch) {
            if (this.gamepadNativeFallbackAllowed) {
                natives.GamepadMultiTouch(actionMasked, pointerId2, i8, i9, i10, i11, i12, i13);
                this.gamepadTouchForwardedToNative = true;
                return;
            }
            return;
        }
        natives.MultiTouch(actionMasked, pointerId2, i8, i9, i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dispatchGamepadTouchEvent(MotionEvent motionEvent, boolean z) {
        this.dispatchingGamepadTouch = true;
        this.gamepadNativeFallbackAllowed = z;
        this.gamepadTouchForwardedToNative = false;
        try {
            super.dispatchTouchEvent(motionEvent);
            this.dispatchingGamepadTouch = false;
            this.gamepadNativeFallbackAllowed = false;
            return this.gamepadTouchForwardedToNative;
        } catch (Throwable th) {
            this.dispatchingGamepadTouch = false;
            this.gamepadNativeFallbackAllowed = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        passTouchEventToCpp(motionEvent);
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
        JNIGLSurfaceView jNIGLSurfaceView;
        boolean z = (isDeviceLocked() || isDeviceAsleep()) ? false : true;
        if (this.hasFocus && z && (jNIGLSurfaceView = this.mGLSurfaceView) != null) {
            jNIGLSurfaceView.onResume();
        }
    }

    public void runOnGLThread(Runnable runnable) {
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView == null || !jNIGLSurfaceView.isInitialized()) {
            return;
        }
        runnable.run();
    }

    public void applyDisplaySettings(int i, boolean z) {
        JNIGLSurfaceView jNIGLSurfaceView = this.mGLSurfaceView;
        if (jNIGLSurfaceView != null) {
            jNIGLSurfaceView.applyDisplaySettings(i, z);
        }
    }

    public static JNIActivity getContext() {
        return mContext;
    }

    public String getFullPath(String str) {
        return getExternalFilesDir(null).getAbsolutePath() + "/" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        AdaptiveTriggers.unregister(this);
        this.gamepadInput.reset();
        this.gamepadInput.unregister(this);
        super.onDestroy();
        this.mGLSurfaceView = null;
        this.mRootView = null;
        if (mContext == this) {
            mContext = null;
        }
    }
}
