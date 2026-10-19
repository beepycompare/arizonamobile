package com.arizona.launcher;

import android.content.Context;
import android.opengl.EGL14;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: GpuCapabilitiesProbe.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/GpuCapabilitiesProbe;", "", "<init>", "()V", "TAG", "", "ASTC_EXTENSION", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", TtmlNode.START, "", "context", "Landroid/content/Context;", "queryAstcSupport", "", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "queryAstcSupport$app", "(Ljavax/microedition/khronos/egl/EGL10;)Ljava/lang/Boolean;", "queryExtensions", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "Ljavax/microedition/khronos/egl/EGLDisplay;", "version", "", "logEglFailure", "operation", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GpuCapabilitiesProbe {
    public static final int $stable = 0;
    private static final String ASTC_EXTENSION = "GL_KHR_texture_compression_astc_ldr";
    private static final String TAG = "GpuCapabilitiesProbe";
    public static final GpuCapabilitiesProbe INSTANCE = new GpuCapabilitiesProbe();
    private static final AtomicBoolean started = new AtomicBoolean();

    private GpuCapabilitiesProbe() {
    }

    public final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (started.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GpuCapabilitiesProbe$start$1(context.getApplicationContext(), null), 3, null);
        }
    }

    public static /* synthetic */ Boolean queryAstcSupport$app$default(GpuCapabilitiesProbe gpuCapabilitiesProbe, EGL10 egl10, int i, Object obj) {
        if ((i & 1) != 0) {
            EGL egl = EGLContext.getEGL();
            Intrinsics.checkNotNull(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            egl10 = (EGL10) egl;
        }
        return gpuCapabilitiesProbe.queryAstcSupport$app(egl10);
    }

    public final Boolean queryAstcSupport$app(EGL10 egl) {
        Intrinsics.checkNotNullParameter(egl, "egl");
        try {
            if (!Intrinsics.areEqual(egl.eglGetCurrentContext(), EGL10.EGL_NO_CONTEXT)) {
                Log.w(TAG, "Skipping GPU probe on a thread with a current EGL context");
                return null;
            }
            EGLDisplay eglGetDisplay = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (Intrinsics.areEqual(eglGetDisplay, EGL10.EGL_NO_DISPLAY)) {
                logEglFailure(egl, "eglGetDisplay");
                return null;
            } else if (!egl.eglInitialize(eglGetDisplay, new int[2])) {
                logEglFailure(egl, "eglInitialize");
                return null;
            } else {
                Intrinsics.checkNotNull(eglGetDisplay);
                String queryExtensions = queryExtensions(egl, eglGetDisplay, 3);
                if (queryExtensions != null || (queryExtensions = queryExtensions(egl, eglGetDisplay, 2)) != null) {
                    boolean z = true;
                    List<String> split$default = StringsKt.split$default((CharSequence) queryExtensions, new char[]{' '}, false, 0, 6, (Object) null);
                    if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
                        for (String str : split$default) {
                            if (Intrinsics.areEqual(str, ASTC_EXTENSION)) {
                                break;
                            }
                        }
                    }
                    z = false;
                    egl.eglTerminate(eglGetDisplay);
                    EGL14.eglReleaseThread();
                    return Boolean.valueOf(z);
                }
                egl.eglTerminate(eglGetDisplay);
                EGL14.eglReleaseThread();
                return null;
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Unable to query GPU capabilities", e);
            return null;
        }
    }

    private final String queryExtensions(EGL10 egl10, EGLDisplay eGLDisplay, int i) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 1, 12352, i == 3 ? 64 : 4, 12344}, eGLConfigArr, 1, iArr)) {
            logEglFailure(egl10, "eglChooseConfig ES" + i);
            return null;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (iArr[0] == 0 || eGLConfig == null) {
            Log.w(TAG, "No offscreen EGL configuration for ES" + i);
            return null;
        }
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, i, 12344});
        if (Intrinsics.areEqual(eglCreateContext, EGL10.EGL_NO_CONTEXT)) {
            logEglFailure(egl10, "eglCreateContext ES" + i);
            return null;
        }
        try {
            EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344});
            if (Intrinsics.areEqual(eglCreatePbufferSurface, EGL10.EGL_NO_SURFACE)) {
                logEglFailure(egl10, "eglCreatePbufferSurface ES" + i);
                return null;
            } else if (!egl10.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                logEglFailure(egl10, "eglMakeCurrent ES" + i);
                egl10.eglDestroySurface(eGLDisplay, eglCreatePbufferSurface);
                return null;
            } else {
                GL gl = eglCreateContext.getGL();
                Intrinsics.checkNotNull(gl, "null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
                String glGetString = ((GL10) gl).glGetString(7939);
                if (glGetString == null) {
                    Log.w(TAG, "GL_EXTENSIONS is unavailable for ES" + i);
                }
                egl10.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroySurface(eGLDisplay, eglCreatePbufferSurface);
                return glGetString;
            }
        } finally {
            egl10.eglDestroyContext(eGLDisplay, eglCreateContext);
        }
    }

    private final void logEglFailure(EGL10 egl10, String str) {
        String num = Integer.toString(egl10.eglGetError(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        Log.w(TAG, str + " failed: EGL error 0x" + num);
    }
}
