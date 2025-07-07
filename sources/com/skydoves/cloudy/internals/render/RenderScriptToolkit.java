package com.skydoves.cloudy.internals.render;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RenderScriptToolkit.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0002\b\u000eJ2\u0010\u0004\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0003\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0017H\u0082 J\u0011\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 JK\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0082 J3\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0082 R\u0014\u0010\u0012\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/skydoves/cloudy/internals/render/RenderScriptToolkit;", "", "<init>", "()V", "blur", "", "inputArray", "vectorSize", "", "sizeX", "sizeY", "radius", "restriction", "Lcom/skydoves/cloudy/internals/render/Range2d;", "blur$cloudy_release", "Landroid/graphics/Bitmap;", "inputBitmap", "outputBitmap", "identityMatrix", "", "getIdentityMatrix$cloudy_release", "()[F", "nativeHandle", "", "shutdown", "", "shutdown$cloudy_release", "createNative", "destroyNative", "nativeBlur", "outputArray", "nativeBlurBitmap", "cloudy_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RenderScriptToolkit {
    public static final int $stable;
    public static final RenderScriptToolkit INSTANCE;
    private static long nativeHandle;

    private final native long createNative();

    private final native void destroyNative(long j);

    private final native void nativeBlur(long j, byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, Range2d range2d);

    private final native void nativeBlurBitmap(long j, Bitmap bitmap, Bitmap bitmap2, int i, Range2d range2d);

    public final Bitmap blur(Bitmap bitmap, Bitmap outputBitmap) {
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        return blur$default(this, bitmap, outputBitmap, 0, null, 12, null);
    }

    public final Bitmap blur(Bitmap bitmap, Bitmap outputBitmap, int i) {
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        return blur$default(this, bitmap, outputBitmap, i, null, 8, null);
    }

    public final byte[] blur$cloudy_release(byte[] inputArray, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(inputArray, "inputArray");
        return blur$cloudy_release$default(this, inputArray, i, i2, i3, 0, null, 48, null);
    }

    public final byte[] blur$cloudy_release(byte[] inputArray, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(inputArray, "inputArray");
        return blur$cloudy_release$default(this, inputArray, i, i2, i3, i4, null, 32, null);
    }

    private RenderScriptToolkit() {
    }

    public static /* synthetic */ byte[] blur$cloudy_release$default(RenderScriptToolkit renderScriptToolkit, byte[] bArr, int i, int i2, int i3, int i4, Range2d range2d, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            i4 = 5;
        }
        int i6 = i4;
        if ((i5 & 32) != 0) {
            range2d = null;
        }
        return renderScriptToolkit.blur$cloudy_release(bArr, i, i2, i3, i6, range2d);
    }

    public final byte[] blur$cloudy_release(byte[] inputArray, int i, int i2, int i3, int i4, Range2d range2d) {
        Intrinsics.checkNotNullParameter(inputArray, "inputArray");
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(("RenderScript Toolkit blur. The vectorSize should be 1 or 4. " + i + " provided.").toString());
        }
        if (inputArray.length >= i2 * i3 * i) {
            if (1 > i4 || i4 >= 26) {
                throw new IllegalArgumentException(("RenderScript Toolkit blur. The radius should be between 1 and 25. " + i4 + " provided.").toString());
            }
            RenderScriptToolkitKt.validateRestriction("blur", i2, i3, range2d);
            byte[] bArr = new byte[inputArray.length];
            nativeBlur(nativeHandle, inputArray, i, i2, i3, i4, bArr, range2d);
            return bArr;
        }
        throw new IllegalArgumentException(("RenderScript Toolkit blur. inputArray is too small for the given dimensions. " + i2 + '*' + i3 + '*' + i + " < " + inputArray.length + '.').toString());
    }

    public static /* synthetic */ Bitmap blur$default(RenderScriptToolkit renderScriptToolkit, Bitmap bitmap, Bitmap bitmap2, int i, Range2d range2d, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5;
        }
        if ((i2 & 8) != 0) {
            range2d = null;
        }
        return renderScriptToolkit.blur(bitmap, bitmap2, i, range2d);
    }

    public final Bitmap blur(Bitmap bitmap, Bitmap outputBitmap, int i, Range2d range2d) {
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        if (bitmap == null) {
            return null;
        }
        RenderScriptToolkitKt.validateBitmap$default("blur", bitmap, false, 4, null);
        if (i == 0) {
            return bitmap;
        }
        if (1 <= i && i < 26) {
            RenderScriptToolkitKt.validateRestriction("blur", bitmap.getWidth(), bitmap.getHeight(), range2d);
            nativeBlurBitmap(nativeHandle, bitmap, outputBitmap, i, range2d);
            return outputBitmap;
        }
        throw new IllegalArgumentException(("RenderScript Toolkit blur. The radius should be between 1 and 25. " + i + " provided.").toString());
    }

    public final float[] getIdentityMatrix$cloudy_release() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    static {
        RenderScriptToolkit renderScriptToolkit = new RenderScriptToolkit();
        INSTANCE = renderScriptToolkit;
        System.loadLibrary("renderscript-toolkit");
        nativeHandle = renderScriptToolkit.createNative();
        $stable = 8;
    }

    public final void shutdown$cloudy_release() {
        destroyNative(nativeHandle);
        nativeHandle = 0L;
    }
}
