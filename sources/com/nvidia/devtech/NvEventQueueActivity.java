package com.nvidia.devtech;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import io.appmetrica.analytics.BuildConfig;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL11;
/* loaded from: classes4.dex */
public abstract class NvEventQueueActivity extends Activity implements SensorEventListener {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static int EGL_OPENGL_ES3_BIT = 64;
    private static final int EGL_RENDERABLE_TYPE = 12352;
    protected SurfaceHolder holder;
    protected SurfaceHolder movieTextHolder;
    protected SurfaceView movieTextView;
    SharedPreferences prefs;
    public View splashView;
    protected SurfaceHolder vidHolder;
    protected SurfaceView vidView;
    protected SurfaceView view;
    public boolean isNativeApp = false;
    public Handler handler = null;
    public boolean paused = false;
    protected boolean wantsMultitouch = false;
    protected boolean supportPauseResume = true;
    protected boolean GetGLExtensions = false;
    protected boolean isFailedError = false;
    protected boolean delayInputForStore = false;
    protected long lastResumeTime = 0;
    private boolean inputPaused = false;
    private AssetManager assetMgr = null;
    int SwapBufferSkip = 0;
    protected boolean IsShowingKeyboard = false;
    boolean capsLockOn = false;
    protected boolean isShieldTV = false;
    protected int maxDisplayWidth = 1920;
    protected int maxDisplayHeight = 1080;
    public boolean delaySetContentView = false;
    boolean Use2Touches = false;
    protected String movieText = "Loading...";
    int vidViewWidth = 1024;
    int vidViewHeight = 600;
    int mVideoWidth = 640;
    int mVideoHeight = 480;
    boolean InVideview = false;
    ViewGroup.LayoutParams myLayout = new ViewGroup.LayoutParams(-2, -2);
    protected boolean wantsAccelerometer = false;
    protected SensorManager mSensorManager = null;
    protected int mSensorDelay = 1;
    protected Display display = null;
    EGL10 egl = null;
    protected GL11 gl = null;
    private boolean ranInit = false;
    protected EGLSurface eglSurface = null;
    protected EGLDisplay eglDisplay = null;
    protected EGLContext eglContext = null;
    protected EGLConfig eglConfig = null;
    protected SurfaceView warView = null;
    protected boolean vidViewCreated = false;
    protected boolean vidViewIsActive = false;
    protected boolean viewIsActive = false;
    protected boolean movieIsStopping = false;
    protected boolean noVidSurface = true;
    protected boolean movieIsStarting = false;
    protected boolean creatingMediaplayer = false;
    protected boolean movieTextViewCreated = false;
    protected boolean movieTextViewIsActive = false;
    protected boolean movieTextViewFirstDestroy = false;
    public String glExtensions = null;
    protected String glVendor = null;
    protected String glRenderer = null;
    protected String glVersion = null;
    public SurfaceHolder cachedSurfaceHolder = null;
    protected int surfaceWidth = 0;
    protected int surfaceHeight = 0;
    protected boolean ResumeEventDone = false;
    protected boolean UseSubtitles = false;
    public boolean HasGLExtensions = false;
    boolean waitingForResume = false;
    protected int redSize = 5;
    protected int greenSize = 6;
    protected int blueSize = 5;
    protected int alphaSize = 0;
    protected int stencilSize = 0;
    protected int[] configAttrs = null;
    protected int[] contextAttrs = null;

    /* loaded from: classes4.dex */
    public class RawData {
        public byte[] data;
        public int length;

        public RawData() {
        }
    }

    /* loaded from: classes4.dex */
    public class RawTexture extends RawData {
        public int height;
        public int width;

        public RawTexture() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public class gSurfaceView extends SurfaceView {
        NvEventQueueActivity myActivity;

        public gSurfaceView(Context context) {
            super(context);
            this.myActivity = null;
        }

        @Override // android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i == 4 && NvEventQueueActivity.this.IsShowingKeyboard) {
                this.myActivity.imeClosed();
                NvEventQueueActivity.this.IsShowingKeyboard = false;
            }
            return false;
        }
    }

    public void DoResumeEvent() {
        if (this.waitingForResume) {
            return;
        }
        new Thread(new Runnable() { // from class: com.nvidia.devtech.NvEventQueueActivity.1
            @Override // java.lang.Runnable
            public void run() {
                NvEventQueueActivity.this.waitingForResume = true;
                while (NvEventQueueActivity.this.cachedSurfaceHolder == null) {
                    NvEventQueueActivity.this.mSleep(1000L);
                }
                NvEventQueueActivity.this.waitingForResume = false;
                NvEventQueueActivity.this.resumeEvent();
                NvEventQueueActivity.this.ResumeEventDone = true;
            }
        }).start();
    }

    public void GamepadReportSurfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public int GetDepthBits() {
        return 16;
    }

    public void GetGLExtensions() {
        GL11 gl11;
        if (this.HasGLExtensions || (gl11 = this.gl) == null || this.cachedSurfaceHolder == null) {
            return;
        }
        this.glVendor = gl11.glGetString(7936);
        this.glExtensions = this.gl.glGetString(7939);
        this.glRenderer = this.gl.glGetString(7937);
        this.glVersion = this.gl.glGetString(7938);
        System.out.println("Vendor: " + this.glVendor);
        System.out.println("Extensions " + this.glExtensions);
        System.out.println("Renderer: " + this.glRenderer);
        System.out.println("glVersion: " + this.glVersion);
        if (this.glVendor != null) {
            this.HasGLExtensions = true;
        }
    }

    public View GetMainView() {
        return this.view;
    }

    public boolean InitEGLAndGLES2(int i) {
        boolean z;
        PrintStream printStream;
        String str;
        System.out.println("InitEGLAndGLES2");
        if (this.cachedSurfaceHolder == null) {
            printStream = System.out;
            str = "InitEGLAndGLES2 failed, cachedSurfaceHolder is null";
        } else {
            if (this.eglContext == null) {
                if (i >= 3) {
                    try {
                        z = initEGL(3, 24);
                    } catch (Exception unused) {
                        z = false;
                    }
                    System.out.println("initEGL 3 " + z);
                } else {
                    z = false;
                }
                if (!z) {
                    this.configAttrs = null;
                    try {
                        z = initEGL(2, GetDepthBits());
                    } catch (Exception unused2) {
                    }
                    System.out.println("initEGL 2 " + z);
                    if (!z) {
                        z = initEGL(2, 16);
                        System.out.println("initEGL 2 " + z);
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                System.out.println("Should we create a surface?");
                if (!this.viewIsActive) {
                    System.out.println("Yes! Calling create surface");
                    createEGLSurface(this.cachedSurfaceHolder);
                    System.out.println("Done creating surface");
                }
                this.viewIsActive = true;
                this.SwapBufferSkip = 1;
                return true;
            }
            printStream = System.out;
            str = "initEGLAndGLES2 failed, core EGL init failure";
        }
        printStream.println(str);
        return false;
    }

    public boolean IsPortrait() {
        return false;
    }

    public native boolean accelerometerEvent(float f, float f2, float f3);

    public native void cleanup();

    protected void cleanupEGL() {
        destroyEGLSurface();
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != null) {
            this.egl.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }
        EGLContext eGLContext = this.eglContext;
        if (eGLContext != null) {
            this.egl.eglDestroyContext(this.eglDisplay, eGLContext);
        }
        EGLDisplay eGLDisplay2 = this.eglDisplay;
        if (eGLDisplay2 != null) {
            this.egl.eglTerminate(eGLDisplay2);
        }
        this.eglDisplay = null;
        this.eglContext = null;
        this.eglSurface = null;
        this.ranInit = false;
        this.eglConfig = null;
        this.cachedSurfaceHolder = null;
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
    }

    protected boolean createEGLSurface(SurfaceHolder surfaceHolder) {
        this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surfaceHolder, null);
        System.out.println("eglSurface: " + this.eglSurface + ", err: " + this.egl.eglGetError());
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
        this.surfaceWidth = iArr[0];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
        this.surfaceHeight = iArr[0];
        System.out.println("checking glVendor == null?");
        if (this.glVendor == null) {
            System.out.println("Making current and back");
            makeCurrent();
            unMakeCurrent();
        }
        System.out.println("Done. Making current and back");
        return true;
    }

    protected void destroyEGLSurface() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != null && this.eglSurface != null) {
            this.egl.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != null) {
            this.egl.eglDestroySurface(this.eglDisplay, eGLSurface);
        }
        this.eglSurface = null;
    }

    public int getOrientation() {
        return this.display.getOrientation();
    }

    public boolean getSupportPauseResume() {
        return this.supportPauseResume;
    }

    public int getSurfaceHeight() {
        return this.surfaceHeight;
    }

    public int getSurfaceWidth() {
        return this.surfaceWidth;
    }

    public void hideSystemUI() {
        SurfaceView surfaceView = this.view;
        if (surfaceView != null) {
            try {
                surfaceView.setSystemUiVisibility(5894);
            } catch (Exception unused) {
            }
        }
    }

    public native void imeClosed();

    public native boolean init(boolean z);

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean initEGL(int i, int i2) {
        int i3;
        int eglGetError;
        int i4;
        int i5;
        if (this.configAttrs == null) {
            this.configAttrs = new int[]{12344};
        }
        int[] iArr = this.configAttrs;
        this.configAttrs = new int[iArr.length + 2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i3 = 1;
            if (i7 >= iArr.length - 1) {
                break;
            }
            this.configAttrs[i7] = iArr[i7];
            i7++;
        }
        int[] iArr2 = this.configAttrs;
        int i8 = i7 + 1;
        iArr2[i7] = EGL_RENDERABLE_TYPE;
        int i9 = i7 + 2;
        if (i == 3) {
            iArr2[i8] = EGL_OPENGL_ES3_BIT;
        } else {
            iArr2[i8] = 4;
        }
        iArr2[i9] = 12344;
        this.contextAttrs = new int[]{EGL_CONTEXT_CLIENT_VERSION, i, 12344};
        if (iArr2 == null) {
            this.configAttrs = new int[]{12344};
        }
        int[] iArr3 = this.configAttrs;
        this.configAttrs = new int[iArr3.length + 12];
        int i10 = 0;
        while (i10 < iArr3.length - 1) {
            this.configAttrs[i10] = iArr3[i10];
            i10++;
        }
        int[] iArr4 = this.configAttrs;
        int i11 = 12324;
        iArr4[i10] = 12324;
        iArr4[i10 + 1] = this.redSize;
        int i12 = 12323;
        iArr4[i10 + 2] = 12323;
        iArr4[i10 + 3] = this.greenSize;
        int i13 = 12322;
        iArr4[i10 + 4] = 12322;
        iArr4[i10 + 5] = this.blueSize;
        iArr4[i10 + 6] = 12321;
        iArr4[i10 + 7] = this.alphaSize;
        iArr4[i10 + 8] = 12326;
        iArr4[i10 + 9] = this.stencilSize;
        iArr4[i10 + 10] = 12325;
        iArr4[i10 + 11] = i2;
        iArr4[i10 + 12] = 12344;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        egl10.eglGetError();
        this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        System.out.println("eglDisplay: " + this.eglDisplay + ", err: " + this.egl.eglGetError());
        boolean eglInitialize = this.egl.eglInitialize(this.eglDisplay, new int[2]);
        System.out.println("EglInitialize returned: " + eglInitialize);
        if (eglInitialize && (eglGetError = this.egl.eglGetError()) == 12288) {
            System.out.println("eglInitialize err: " + eglGetError);
            EGLConfig[] eGLConfigArr = new EGLConfig[20];
            int[] iArr5 = new int[1];
            this.egl.eglChooseConfig(this.eglDisplay, this.configAttrs, eGLConfigArr, 20, iArr5);
            System.out.println("eglChooseConfig err: " + this.egl.eglGetError());
            System.out.println("num_configs " + iArr5[0]);
            int[] iArr6 = new int[1];
            int i14 = 16777216;
            int i15 = 0;
            while (i15 < iArr5[i6]) {
                int i16 = i6;
                while (true) {
                    if (i16 < ((iArr3.length - i3) >> i3)) {
                        i4 = i6;
                        i5 = i3;
                        int i17 = i16 * 2;
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], this.configAttrs[i17], iArr6);
                        int i18 = iArr6[i4];
                        int i19 = this.configAttrs[i17 + 1];
                        if ((i18 & i19) != i19) {
                            break;
                        }
                        i16++;
                        i6 = i4;
                        i3 = i5;
                    } else {
                        i4 = i6;
                        i5 = i3;
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], i11, iArr6);
                        int i20 = iArr6[i4];
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], i12, iArr6);
                        int i21 = iArr6[i4];
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], i13, iArr6);
                        int i22 = iArr6[i4];
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], 12321, iArr6);
                        int i23 = iArr6[i4];
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], 12325, iArr6);
                        int i24 = iArr6[i4];
                        this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], 12326, iArr6);
                        int abs = ((((Math.abs(i20 - this.redSize) + Math.abs(i21 - this.greenSize)) + Math.abs(i22 - this.blueSize)) + Math.abs(i23 - this.alphaSize)) << 16) + (Math.abs(i24 - i2) << 8) + Math.abs(iArr6[i4] - this.stencilSize);
                        if (abs < i14) {
                            int i25 = i4;
                            while (true) {
                                int[] iArr7 = this.configAttrs;
                                if (i25 >= ((iArr7.length - 1) >> 1)) {
                                    break;
                                }
                                this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i15], iArr7[i25 * 2], iArr6);
                                i25++;
                            }
                            this.eglConfig = eGLConfigArr[i15];
                            i14 = abs;
                        }
                    }
                }
                i15++;
                i6 = i4;
                i3 = i5;
                i11 = 12324;
                i12 = 12323;
                i13 = 12322;
            }
            boolean z = i6;
            boolean z2 = i3;
            EGLConfig eGLConfig = this.eglConfig;
            if (eGLConfig == null) {
                this.configAttrs = null;
                return z;
            }
            this.eglContext = this.egl.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, this.contextAttrs);
            System.out.println("eglCreateContext: " + this.egl.eglGetError());
            this.gl = (GL11) this.eglContext.getGL();
            return z2;
        }
        return false;
    }

    public native void jniNvAPKInit(Object obj);

    public native boolean keyEvent(int i, int i2, int i3, int i4, KeyEvent keyEvent);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RawData loadFile(String str) {
        RawData rawData = new RawData();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream("/data/" + str);
                } catch (Exception unused) {
                    fileInputStream = getAssets().open(str);
                }
            } catch (Exception unused2) {
            }
            try {
                int available = fileInputStream.available();
                rawData.length = available;
                rawData.data = new byte[available];
                fileInputStream.read(rawData.data);
            } catch (IOException unused3) {
            }
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public RawTexture loadTexture(String str) {
        InputStream inputStream;
        RawTexture rawTexture = new RawTexture();
        try {
            try {
                inputStream = new FileInputStream("/data/" + str);
            } catch (Exception unused) {
                inputStream = getAssets().open(str);
            }
        } catch (Exception unused2) {
            inputStream = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            rawTexture.width = decodeStream.getWidth();
            rawTexture.height = decodeStream.getHeight();
            int width = decodeStream.getWidth() * decodeStream.getHeight();
            int[] iArr = new int[width];
            decodeStream.getPixels(iArr, 0, decodeStream.getWidth(), 0, 0, decodeStream.getWidth(), decodeStream.getHeight());
            int[] iArr2 = new int[decodeStream.getWidth()];
            int width2 = decodeStream.getWidth();
            int height = decodeStream.getHeight();
            for (int i = 0; i < (height >> 1); i++) {
                int i2 = i * width2;
                System.arraycopy(iArr, i2, iArr2, 0, width2);
                int i3 = ((height - 1) - i) * width2;
                System.arraycopy(iArr, i3, iArr, i2, width2);
                System.arraycopy(iArr2, 0, iArr, i3, width2);
            }
            rawTexture.length = width * 4;
            rawTexture.data = new byte[rawTexture.length];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = 0;
                while (i7 < width2) {
                    int i8 = iArr[i5];
                    int i9 = i4 + 1;
                    rawTexture.data[i4] = (byte) ((i8 >> 16) & 255);
                    int i10 = i4 + 2;
                    rawTexture.data[i9] = (byte) ((i8 >> 8) & 255);
                    int i11 = i4 + 3;
                    rawTexture.data[i10] = (byte) (i8 & 255);
                    i4 += 4;
                    rawTexture.data[i11] = (byte) ((i8 >> 24) & 255);
                    i7++;
                    i5++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawTexture;
    }

    public native void lowMemoryEvent();

    public void mSleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (r0.eglMakeCurrent(r2, r3, r3, r5.eglContext) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean makeCurrent() {
        EGLContext eGLContext = this.eglContext;
        if (eGLContext != null) {
            EGLSurface eGLSurface = this.eglSurface;
            if (eGLSurface == null) {
                System.out.println("eglSurface is NULL");
                return false;
            }
            if (!this.egl.eglMakeCurrent(this.eglDisplay, eGLSurface, eGLSurface, eGLContext)) {
                System.out.println("eglMakeCurrent err: " + this.egl.eglGetError());
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface2 = this.eglSurface;
            }
            GetGLExtensions();
            return true;
        }
        System.out.println("eglContext is NULL");
        return false;
    }

    public native boolean multiTouchEvent(int i, int i2, int i3, int i4, int i5, int i6, MotionEvent motionEvent);

    public native boolean multiTouchEvent4(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, MotionEvent motionEvent);

    public void nativeCrashed() {
        System.err.println("nativeCrashed");
        if (this.prefs != null) {
            try {
                System.err.println("saved game was:\n" + this.prefs.getString("savedGame", ""));
            } catch (Exception unused) {
            }
        }
        new RuntimeException("crashed here (native trace should follow after the Java trace)").printStackTrace();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        System.out.println("**** NvEventQueueActivity onCreate");
        NvUtil.getInstance().setActivity(this);
        super.onCreate(bundle);
        this.handler = new Handler();
        if (this.isFailedError) {
            return;
        }
        if (this.wantsAccelerometer && this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) getSystemService("sensor");
        }
        NvAPKFileHelper.getInstance().setContext(this);
        new NvAPKFile().is = null;
        try {
            AssetManager assets = getAssets();
            this.assetMgr = assets;
            jniNvAPKInit(assets);
        } catch (UnsatisfiedLinkError unused) {
        }
        this.display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        systemInit();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.supportPauseResume) {
            quitAndWait();
            finish();
        }
        super.onDestroy();
        systemCleanup();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean z = false;
        if (i != 89 && i != 85 && i != 90) {
            if (i != 82 && i != 4) {
                z = super.onKeyDown(i, keyEvent);
            }
            if (!z) {
                return keyEvent(keyEvent.getAction(), i, keyEvent.getUnicodeChar(), keyEvent.getMetaState(), keyEvent);
            }
        }
        return z;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        KeyEvent keyEvent2;
        if (i == 115) {
            boolean isCapsLockOn = keyEvent.isCapsLockOn();
            this.capsLockOn = isCapsLockOn;
            keyEvent2 = keyEvent;
            keyEvent(isCapsLockOn ? 3 : 4, BuildConfig.API_LEVEL, 0, 0, keyEvent2);
        } else {
            keyEvent2 = keyEvent;
        }
        if (i == 89 || i == 85 || i == 90) {
            return false;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent2);
        return !onKeyUp ? keyEvent(keyEvent2.getAction(), i, keyEvent2.getUnicodeChar(), keyEvent2.getMetaState(), keyEvent2) : onKeyUp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.ResumeEventDone) {
            pauseEvent();
        }
        this.paused = true;
        this.inputPaused = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.lastResumeTime = SystemClock.uptimeMillis() + 300;
        super.onResume();
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), this.mSensorDelay);
        }
        this.paused = false;
        this.inputPaused = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        float f2;
        if (sensorEvent.sensor.getType() == 1) {
            int rotation = this.display.getRotation();
            if (rotation == 0) {
                f = -sensorEvent.values[0];
                f2 = sensorEvent.values[1];
            } else if (rotation == 1) {
                f = sensorEvent.values[1];
                f2 = sensorEvent.values[0];
            } else if (rotation == 2) {
                f = sensorEvent.values[0];
                f2 = sensorEvent.values[1];
            } else if (rotation != 3) {
                f = 0.0f;
                f2 = 0.0f;
            } else {
                f = -sensorEvent.values[1];
                f2 = sensorEvent.values[0];
            }
            accelerometerEvent(f, f2, sensorEvent.values[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.inputPaused || (this.delayInputForStore && motionEvent.getEventTime() < this.lastResumeTime)) {
            return false;
        }
        if (this.delayInputForStore && motionEvent.getEventTime() > this.lastResumeTime + 5000) {
            this.delayInputForStore = false;
        }
        if (onTouchEvent) {
            return onTouchEvent;
        }
        if (this.wantsMultitouch) {
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < pointerCount; i10++) {
                if (i == 0) {
                    i2 = (int) motionEvent.getX(i10);
                    i3 = (int) motionEvent.getY(i10);
                } else if (i == 1) {
                    i4 = (int) motionEvent.getX(i10);
                    i5 = (int) motionEvent.getY(i10);
                } else {
                    boolean z = this.Use2Touches;
                    if (z || i != 2) {
                        if (!z && i == 3) {
                            i8 = (int) motionEvent.getX(i10);
                            i9 = (int) motionEvent.getY(i10);
                        }
                    } else {
                        i6 = (int) motionEvent.getX(i10);
                        i7 = (int) motionEvent.getY(i10);
                    }
                }
                i++;
            }
            boolean z2 = this.Use2Touches;
            int i11 = i;
            int action = motionEvent.getAction();
            return z2 ? multiTouchEvent(action, i11, i2, i3, i4, i5, motionEvent) : multiTouchEvent4(action, i11, i2, i3, i4, i5, i6, i7, i8, i9, motionEvent);
        }
        return touchEvent(motionEvent.getAction(), (int) motionEvent.getX(), (int) motionEvent.getY(), motionEvent);
    }

    public native void pauseEvent();

    public native void quitAndWait();

    public native void resumeEvent();

    public void setGameWindowSize(int i, int i2) {
        if ((!IsPortrait() || i <= i2) && (IsPortrait() || i2 <= i)) {
            setWindowSize(i, i2);
        } else {
            setWindowSize(i2, i);
        }
    }

    public native void setWindowSize(int i, int i2);

    public void showSystemUI() {
        SurfaceView surfaceView = this.view;
        if (surfaceView != null) {
            try {
                surfaceView.setSystemUiVisibility(1792);
            } catch (Exception unused) {
            }
        }
    }

    public boolean swapBuffers() {
        PrintStream printStream;
        String str;
        int i = this.SwapBufferSkip;
        if (i <= 0) {
            EGLSurface eGLSurface = this.eglSurface;
            if (eGLSurface == null) {
                printStream = System.out;
                str = "eglSurface is NULL";
            } else if (!this.egl.eglSwapBuffers(this.eglDisplay, eGLSurface)) {
                printStream = System.out;
                str = "eglSwapBufferrr: " + this.egl.eglGetError();
            }
            printStream.println(str);
            return false;
        }
        this.SwapBufferSkip = i - 1;
        System.out.println("swapBuffer wait");
        return true;
    }

    protected void systemCleanup() {
        if (this.ranInit) {
            cleanup();
        }
        cleanupEGL();
    }

    protected boolean systemInit() {
        View view;
        System.out.println("In systemInit");
        boolean z = this.GetGLExtensions;
        if (!z && this.supportPauseResume) {
            init(z);
        }
        SurfaceView surfaceView = this.warView;
        if (surfaceView == null) {
            gSurfaceView gsurfaceview = new gSurfaceView(this);
            this.view = gsurfaceview;
            gsurfaceview.myActivity = this;
        } else {
            this.view = surfaceView;
        }
        SurfaceHolder holder = this.view.getHolder();
        this.holder = holder;
        holder.setType(2);
        this.holder.setKeepScreenOn(true);
        if (this.isShieldTV) {
            this.holder.setFixedSize(this.maxDisplayWidth, this.maxDisplayHeight);
        }
        this.holder.addCallback(new SurfaceHolder.Callback() { // from class: com.nvidia.devtech.NvEventQueueActivity.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                System.out.println("Surface changed: " + i2 + ", " + i3);
                NvEventQueueActivity.this.surfaceWidth = i2;
                NvEventQueueActivity.this.surfaceHeight = i3;
                NvEventQueueActivity nvEventQueueActivity = NvEventQueueActivity.this;
                nvEventQueueActivity.setGameWindowSize(nvEventQueueActivity.surfaceWidth, NvEventQueueActivity.this.surfaceHeight);
                NvEventQueueActivity.this.hideSystemUI();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                boolean z2 = NvEventQueueActivity.this.cachedSurfaceHolder == null;
                NvEventQueueActivity.this.cachedSurfaceHolder = surfaceHolder;
                if (!z2 && NvEventQueueActivity.this.ResumeEventDone) {
                    NvEventQueueActivity.this.resumeEvent();
                }
                NvEventQueueActivity.this.ranInit = true;
                if (!NvEventQueueActivity.this.supportPauseResume) {
                    NvEventQueueActivity nvEventQueueActivity = NvEventQueueActivity.this;
                    nvEventQueueActivity.init(nvEventQueueActivity.GetGLExtensions);
                }
                System.out.println("surfaceCreated: w:" + NvEventQueueActivity.this.surfaceWidth + ", h:" + NvEventQueueActivity.this.surfaceHeight);
                NvEventQueueActivity nvEventQueueActivity2 = NvEventQueueActivity.this;
                nvEventQueueActivity2.setGameWindowSize(nvEventQueueActivity2.surfaceWidth, NvEventQueueActivity.this.surfaceHeight);
                if (NvEventQueueActivity.this.GetGLExtensions && NvEventQueueActivity.this.supportPauseResume && z2) {
                    NvEventQueueActivity nvEventQueueActivity3 = NvEventQueueActivity.this;
                    nvEventQueueActivity3.init(nvEventQueueActivity3.GetGLExtensions);
                }
                if (z2) {
                    NvEventQueueActivity.this.GamepadReportSurfaceCreated(surfaceHolder);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                NvEventQueueActivity.this.pauseEvent();
                NvEventQueueActivity.this.destroyEGLSurface();
                NvEventQueueActivity.this.viewIsActive = false;
            }
        });
        if (!this.delaySetContentView) {
            if (this.view.getParent() != null) {
                System.out.println("view.getParent() != null");
                view = (View) this.view.getParent();
            } else {
                view = this.view;
            }
            setContentView(view);
        }
        this.view.setFocusable(true);
        this.view.setFocusableInTouchMode(true);
        if (!this.noVidSurface) {
            SurfaceView surfaceView2 = new SurfaceView(this);
            this.vidView = surfaceView2;
            SurfaceHolder holder2 = surfaceView2.getHolder();
            this.vidHolder = holder2;
            holder2.addCallback(new SurfaceHolder.Callback() { // from class: com.nvidia.devtech.NvEventQueueActivity.3
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                    NvEventQueueActivity.this.vidViewWidth = i2;
                    NvEventQueueActivity.this.vidViewHeight = i3;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    NvEventQueueActivity.this.vidViewIsActive = true;
                    if (!NvEventQueueActivity.this.vidViewCreated) {
                        if (NvEventQueueActivity.this.UseSubtitles) {
                            NvEventQueueActivity.this.movieTextView.setVisibility(0);
                        } else {
                            NvEventQueueActivity.this.vidView.setVisibility(4);
                        }
                        NvEventQueueActivity.this.vidViewCreated = true;
                    } else if (NvEventQueueActivity.this.UseSubtitles) {
                        NvEventQueueActivity.this.movieTextView.setVisibility(0);
                    }
                    NvEventQueueActivity.this.InVideview = false;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    if (NvEventQueueActivity.this.UseSubtitles) {
                        NvEventQueueActivity.this.movieTextView.setVisibility(4);
                    }
                    NvEventQueueActivity.this.vidViewIsActive = false;
                    NvEventQueueActivity.this.movieIsStopping = false;
                    NvEventQueueActivity.this.InVideview = false;
                }
            });
            this.vidHolder.setType(3);
            if (this.UseSubtitles) {
                SurfaceView surfaceView3 = new SurfaceView(this);
                this.movieTextView = surfaceView3;
                SurfaceHolder holder3 = surfaceView3.getHolder();
                this.movieTextHolder = holder3;
                holder3.addCallback(new SurfaceHolder.Callback() { // from class: com.nvidia.devtech.NvEventQueueActivity.4
                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                        System.out.println("surfaceChanged called - movieTextView");
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                        System.out.println("surface2222222Created called - subView");
                        Canvas lockCanvas = NvEventQueueActivity.this.movieTextHolder.lockCanvas();
                        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        NvEventQueueActivity.this.movieTextHolder.unlockCanvasAndPost(lockCanvas);
                        if (!NvEventQueueActivity.this.movieTextViewCreated) {
                            NvEventQueueActivity.this.movieTextViewCreated = true;
                        }
                        NvEventQueueActivity.this.movieTextViewIsActive = true;
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                        System.out.println("surfaceDestroyed called - movieTextView");
                        NvEventQueueActivity.this.movieTextViewFirstDestroy = true;
                        NvEventQueueActivity.this.movieTextViewIsActive = false;
                    }
                });
                this.movieTextHolder.setType(0);
            }
        }
        if (!this.noVidSurface) {
            this.vidView.setZOrderOnTop(true);
            this.vidHolder.setFormat(-3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addContentView(this.vidView, layoutParams);
            if (this.UseSubtitles) {
                this.movieTextHolder.setFormat(-3);
                addContentView(this.movieTextView, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        return true;
    }

    public native boolean touchEvent(int i, int i2, int i3, MotionEvent motionEvent);

    public boolean unMakeCurrent() {
        if (this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
            return true;
        }
        System.out.println("egl(Un)MakeCurrent err: " + this.egl.eglGetError());
        return false;
    }
}
