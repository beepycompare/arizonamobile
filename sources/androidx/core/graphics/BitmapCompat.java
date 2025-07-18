package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.ReplaceWith;
/* loaded from: classes2.dex */
public final class BitmapCompat {
    static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }

    @ReplaceWith(expression = "bitmap.hasMipMap()")
    @Deprecated
    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    @ReplaceWith(expression = "bitmap.setHasMipMap(hasMipMap)")
    @Deprecated
    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }

    @ReplaceWith(expression = "bitmap.getAllocationByteCount()")
    @Deprecated
    public static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a3, code lost:
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10) == false) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2, Rect rect, boolean z) {
        int i3;
        double floor;
        double floor2;
        Bitmap bitmap2;
        int i4;
        int i5;
        boolean z2;
        char c;
        Bitmap bitmap3;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        Bitmap copyBitmapIfHardware = Build.VERSION.SDK_INT >= 27 ? Api27Impl.copyBitmapIfHardware(bitmap) : bitmap;
        int width = rect != null ? rect.width() : bitmap.getWidth();
        int height = rect != null ? rect.height() : bitmap.getHeight();
        float f = i / width;
        float f2 = i2 / height;
        int i6 = rect != null ? rect.left : 0;
        int i7 = rect != null ? rect.top : 0;
        if (i6 == 0 && i7 == 0 && i == bitmap.getWidth() && i2 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == copyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : copyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setPaintBlendMode(paint);
        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (width == i && height == i2) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, copyBitmapIfHardware.getConfig());
            new Canvas(createBitmap).drawBitmap(copyBitmapIfHardware, -i6, -i7, paint);
            return createBitmap;
        }
        double log = Math.log(2.0d);
        if (f > 1.0f) {
            i3 = i6;
            floor = Math.ceil(Math.log(f) / log);
        } else {
            i3 = i6;
            floor = Math.floor(Math.log(f) / log);
        }
        int i8 = (int) floor;
        if (f2 > 1.0f) {
            floor2 = Math.ceil(Math.log(f2) / log);
        } else {
            floor2 = Math.floor(Math.log(f2) / log);
        }
        int i9 = (int) floor2;
        if (!z || Build.VERSION.SDK_INT < 27 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmap2 = null;
            i4 = i3;
            i5 = 0;
        } else {
            Bitmap createBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(i8 > 0 ? sizeAtStep(width, i, 1, i8) : width, i9 > 0 ? sizeAtStep(height, i2, 1, i9) : height, bitmap, true);
            new Canvas(createBitmapWithSourceColorspace).drawBitmap(copyBitmapIfHardware, -i3, -i7, paint);
            bitmap2 = copyBitmapIfHardware;
            copyBitmapIfHardware = createBitmapWithSourceColorspace;
            i5 = 1;
            i7 = 0;
            i4 = 0;
        }
        Rect rect2 = new Rect(i4, i7, width, height);
        Rect rect3 = new Rect();
        int i10 = i8;
        int i11 = i9;
        while (true) {
            if (i10 == 0 && i11 == 0) {
                break;
            }
            if (i10 < 0) {
                i10++;
            } else if (i10 > 0) {
                i10--;
            }
            if (i11 < 0) {
                i11++;
            } else if (i11 > 0) {
                i11--;
            }
            int i12 = i11;
            int i13 = i10;
            rect3.set(0, 0, sizeAtStep(width, i, i10, i8), sizeAtStep(height, i2, i12, i9));
            boolean z3 = i13 == 0 && i12 == 0;
            boolean z4 = bitmap2 != null && bitmap2.getWidth() == i && bitmap2.getHeight() == i2;
            if (bitmap2 == null || bitmap2 == bitmap) {
                z2 = z3;
            } else {
                if (z) {
                    z2 = z3;
                    if (Build.VERSION.SDK_INT >= 27) {
                    }
                } else {
                    z2 = z3;
                }
                if (!z2 || (z4 && i5 == 0)) {
                    bitmap3 = bitmap2;
                    c = 27;
                    new Canvas(bitmap3).drawBitmap(copyBitmapIfHardware, rect2, rect3, paint);
                    rect2.set(rect3);
                    bitmap2 = copyBitmapIfHardware;
                    copyBitmapIfHardware = bitmap3;
                    i10 = i13;
                    i11 = i12;
                }
            }
            if (bitmap2 != bitmap && bitmap2 != null) {
                bitmap2.recycle();
            }
            int sizeAtStep = sizeAtStep(width, i, i13 > 0 ? i5 : i13, i8);
            int sizeAtStep2 = sizeAtStep(height, i2, i12 > 0 ? i5 : i12, i9);
            c = 27;
            if (Build.VERSION.SDK_INT >= 27) {
                bitmap3 = Api27Impl.createBitmapWithSourceColorspace(sizeAtStep, sizeAtStep2, bitmap, z && !z2);
            } else {
                bitmap3 = Bitmap.createBitmap(sizeAtStep, sizeAtStep2, copyBitmapIfHardware.getConfig());
            }
            new Canvas(bitmap3).drawBitmap(copyBitmapIfHardware, rect2, rect3, paint);
            rect2.set(rect3);
            bitmap2 = copyBitmapIfHardware;
            copyBitmapIfHardware = bitmap3;
            i10 = i13;
            i11 = i12;
        }
        if (bitmap2 != bitmap && bitmap2 != null) {
            bitmap2.recycle();
        }
        return copyBitmapIfHardware;
    }

    private BitmapCompat() {
    }

    /* loaded from: classes2.dex */
    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
                return bitmap.copy(config, true);
            }
            return bitmap;
        }
    }

    /* loaded from: classes2.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}
