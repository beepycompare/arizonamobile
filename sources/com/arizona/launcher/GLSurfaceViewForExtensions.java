package com.arizona.launcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: GLSurfaceViewForExtensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/GLSurfaceViewForExtensions;", "Landroid/opengl/GLSurfaceView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "glVersion", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GLSurfaceViewForExtensions extends GLSurfaceView {
    public static final int $stable = 8;
    private final int glVersion;

    public GLSurfaceViewForExtensions(final Context context) {
        super(context);
        this.glVersion = 2;
        setEGLContextClientVersion(2);
        setRenderer(new GLSurfaceView.Renderer() { // from class: com.arizona.launcher.GLSurfaceViewForExtensions.1
            @Override // android.opengl.GLSurfaceView.Renderer
            public void onDrawFrame(GL10 gl) {
                Intrinsics.checkNotNullParameter(gl, "gl");
            }

            @Override // android.opengl.GLSurfaceView.Renderer
            public void onSurfaceChanged(GL10 gl, int i, int i2) {
                Intrinsics.checkNotNullParameter(gl, "gl");
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) "adreno", false, 2, (java.lang.Object) null) != false) goto L12;
             */
            @Override // android.opengl.GLSurfaceView.Renderer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                String str;
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor edit;
                SharedPreferences.Editor putString;
                SharedPreferences sharedPreferences2;
                SharedPreferences.Editor edit2;
                SharedPreferences.Editor putString2;
                String glGetString;
                if (gl10 == null || (glGetString = gl10.glGetString(7937)) == null) {
                    str = null;
                } else {
                    str = glGetString.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                }
                String str2 = "mali";
                if (str != null) {
                    String str3 = str;
                    if (!StringsKt.contains$default((CharSequence) str3, (CharSequence) "mali", false, 2, (Object) null)) {
                        String str4 = "powervr";
                        if (!StringsKt.contains$default((CharSequence) str3, (CharSequence) "powervr", false, 2, (Object) null)) {
                            str4 = "adreno";
                        }
                        str2 = str4;
                    }
                    Context context2 = context;
                    if (context2 != null && (sharedPreferences2 = context2.getSharedPreferences("gpu_type", 0)) != null && (edit2 = sharedPreferences2.edit()) != null && (putString2 = edit2.putString("GPU", str2)) != null) {
                        putString2.apply();
                    }
                    Log.d("GLSurfaceView", "GPU: ".concat(str2));
                    return;
                }
                Context context3 = context;
                if (context3 != null && (sharedPreferences = context3.getSharedPreferences("gpu_type", 0)) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString("GPU", "mali")) != null) {
                    putString.apply();
                }
                Log.d("GLSurfaceView", "GPU: ERROR");
            }
        });
    }
}
