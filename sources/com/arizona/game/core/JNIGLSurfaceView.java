package com.arizona.game.core;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.arizona.game.natives;
import com.google.firebase.messaging.Constants;
import com.miami.game.core.settings.SettingsMenuDefaults;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class JNIGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final int ANDROID_15_API_LEVEL = 35;
    private static final int ARR_QUERY_API_LEVEL = 36;
    private static final float DEFAULT_MAX_FPS = 60.0f;
    private static final String TAG = "JNIGLSurfaceView";
    private final DisplayManager.DisplayListener displayListener;
    private final DisplayManager displayManager;
    private volatile boolean fakeVSyncEnabled;
    private boolean initialized;
    private int lastAppliedFrameLimit;
    private volatile float requestedFrameRate;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum ArrSupport {
        SUPPORTED,
        UNSUPPORTED,
        UNKNOWN
    }

    public JNIGLSurfaceView(Context context) {
        super(context);
        this.lastAppliedFrameLimit = -1;
        this.initialized = false;
        this.displayListener = new DisplayManager.DisplayListener() { // from class: com.arizona.game.core.JNIGLSurfaceView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                Display resolveDisplay = JNIGLSurfaceView.this.resolveDisplay();
                if (resolveDisplay == null || resolveDisplay.getDisplayId() != i) {
                    return;
                }
                JNIGLSurfaceView.this.applyNativeFrameLimit(resolveDisplay);
            }
        };
        this.displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        this.requestedFrameRate = resolveRequestedFrameRate();
        this.fakeVSyncEnabled = resolveFakeVSyncEnabled();
        getHolder().addCallback(this);
    }

    private String getSettingsJson() {
        if (getContext() instanceof GameSettingsProvider) {
            try {
                String gameSettingsJson = ((GameSettingsProvider) getContext()).getGameSettingsJson();
                if (gameSettingsJson != null) {
                    return !gameSettingsJson.isEmpty() ? gameSettingsJson : "{}";
                }
                return "{}";
            } catch (Exception e) {
                Log.e(TAG, "Unable to obtain game settings from host", e);
                return "{}";
            }
        }
        return "{}";
    }

    private float resolveRequestedFrameRate() {
        try {
            float optDouble = (float) new JSONObject(getSettingsJson()).optDouble(SettingsMenuDefaults.KEY_VIDEO_MAX_FPS, 60.0d);
            return optDouble > 0.0f ? optDouble : DEFAULT_MAX_FPS;
        } catch (Exception e) {
            Log.w(TAG, "Unable to resolve requested frame rate", e);
            return DEFAULT_MAX_FPS;
        }
    }

    private boolean resolveFakeVSyncEnabled() {
        try {
            return new JSONObject(getSettingsJson()).optInt(SettingsMenuDefaults.KEY_VIDEO_VSYNC, 1) != 0;
        } catch (Exception e) {
            Log.w(TAG, "Unable to resolve VSync setting", e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Display resolveDisplay() {
        Display display = getDisplay();
        if (display != null) {
            return display;
        }
        DisplayManager displayManager = this.displayManager;
        if (displayManager != null) {
            return displayManager.getDisplay(0);
        }
        return null;
    }

    private ArrSupport getArrSupport(Display display) {
        if (Build.VERSION.SDK_INT < 35) {
            return ArrSupport.UNSUPPORTED;
        }
        if (Build.VERSION.SDK_INT < 36) {
            return ArrSupport.UNKNOWN;
        }
        try {
            if (Boolean.TRUE.equals(Display.class.getMethod("hasArrSupport", new Class[0]).invoke(display, new Object[0]))) {
                return ArrSupport.SUPPORTED;
            }
            return ArrSupport.UNSUPPORTED;
        } catch (ReflectiveOperationException | RuntimeException e) {
            Log.w(TAG, "Unable to query adaptive refresh-rate support", e);
            return ArrSupport.UNKNOWN;
        }
    }

    private int calculateNativeFrameLimit(Display display) {
        Display.Mode[] supportedModes;
        int max = Math.max(1, Math.round(this.requestedFrameRate));
        if (this.fakeVSyncEnabled && display != null) {
            float refreshRate = display.getRefreshRate();
            if (!Float.isNaN(refreshRate) && !Float.isInfinite(refreshRate) && refreshRate > 1.0f) {
                ArrSupport arrSupport = getArrSupport(display);
                if (arrSupport == ArrSupport.SUPPORTED) {
                    Display.Mode mode = display.getMode();
                    for (Display.Mode mode2 : display.getSupportedModes()) {
                        if (mode2.getPhysicalWidth() == mode.getPhysicalWidth() && mode2.getPhysicalHeight() == mode.getPhysicalHeight()) {
                            refreshRate = Math.max(refreshRate, mode2.getRefreshRate());
                        }
                    }
                    return Math.max(1, Math.min(max, Math.round(refreshRate)));
                }
                if (arrSupport == ArrSupport.UNSUPPORTED) {
                    refreshRate -= 1.0f;
                }
                return Math.max(1, Math.min(max, Math.round(refreshRate)));
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyNativeFrameLimit(Display display) {
        int calculateNativeFrameLimit = calculateNativeFrameLimit(display);
        natives.SetFrameLimit(calculateNativeFrameLimit);
        if (calculateNativeFrameLimit != this.lastAppliedFrameLimit) {
            Log.i(TAG, "Frame pacing: requested=" + this.requestedFrameRate + ", effective=" + calculateNativeFrameLimit + ", refresh=" + (display != null ? display.getRefreshRate() : 0.0f) + ", fakeVSync=" + this.fakeVSyncEnabled + ", ARR=" + (display != null ? getArrSupport(display) : ArrSupport.UNKNOWN));
            this.lastAppliedFrameLimit = calculateNativeFrameLimit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyDisplayConfiguration(Surface surface) {
        Display resolveDisplay = resolveDisplay();
        if (Build.VERSION.SDK_INT >= 30 && surface != null && surface.isValid()) {
            try {
                surface.setFrameRate(this.requestedFrameRate, 0);
            } catch (RuntimeException e) {
                Log.w(TAG, "Unable to apply requested frame rate", e);
            }
        }
        applyNativeFrameLimit(resolveDisplay);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyDisplaySettings(int i, boolean z) {
        this.requestedFrameRate = Math.max(1.0f, i);
        this.fakeVSyncEnabled = z;
        post(new Runnable() { // from class: com.arizona.game.core.JNIGLSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                JNIGLSurfaceView jNIGLSurfaceView = JNIGLSurfaceView.this;
                jNIGLSurfaceView.applyDisplayConfiguration(jNIGLSurfaceView.getHolder().getSurface());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDisplayConfigurationChanged() {
        applyDisplayConfiguration(getHolder().getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        natives.SurfaceCreated(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!this.initialized) {
            initialise(i2, i3);
            this.initialized = true;
        } else {
            natives.Resize(i2, i3);
        }
        applyDisplayConfiguration(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        natives.SurfaceDestroyed();
    }

    private void initialise(int i, int i2) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("project", 0);
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            jSONObject.put("gameSettings", getSettingsJson());
            if (getContext() instanceof GameSettingsProvider) {
                str = ((GameSettingsProvider) getContext()).getResourceOverlayConfigJson();
            } else {
                str = "{}";
            }
            jSONObject.put("resourceOverlay", new JSONObject(str));
        } catch (Exception unused) {
        }
        Log.d(TAG, jSONObject.toString());
        natives.Init(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = this.displayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.displayListener, null);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        DisplayManager displayManager = this.displayManager;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.displayListener);
        }
        super.onDetachedFromWindow();
    }

    public void onResume() {
        applyDisplayConfiguration(getHolder().getSurface());
        natives.Resume();
    }

    public void onPause() {
        natives.Pause();
    }
}
