package coil3.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.math.MathKt;
/* compiled from: DrawableUtils.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/util/DrawableUtils;", "", "<init>", "()V", "DEFAULT_SIZE", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(z, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable mutate = drawable.mutate();
        int width = Utils_androidKt.getWidth(mutate);
        if (width <= 0) {
            width = 512;
        }
        int height = Utils_androidKt.getHeight(mutate);
        int i = height > 0 ? height : 512;
        long m7771computeDstSizesEdh43o = DecodeUtils.m7771computeDstSizesEdh43o(width, i, size, scale, Size.ORIGINAL);
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i, IntPair.m7829getFirstimpl(m7771computeDstSizesEdh43o), IntPair.m7830getSecondimpl(m7771computeDstSizesEdh43o), scale);
        int roundToInt = MathKt.roundToInt(width * computeSizeMultiplier);
        int roundToInt2 = MathKt.roundToInt(computeSizeMultiplier * i);
        Bitmap createBitmap = Bitmap.createBitmap(roundToInt, roundToInt2, BitmapsKt.toSoftware(config));
        Rect bounds = mutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        mutate.setBounds(0, 0, roundToInt, roundToInt2);
        mutate.draw(new Canvas(createBitmap));
        mutate.setBounds(i2, i3, i4, i5);
        return createBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == BitmapsKt.toSoftware(config);
    }

    private final boolean isSizeValid(boolean z, Bitmap bitmap, Size size, Scale scale) {
        if (z) {
            return true;
        }
        long m7771computeDstSizesEdh43o = DecodeUtils.m7771computeDstSizesEdh43o(bitmap.getWidth(), bitmap.getHeight(), size, scale, Size.ORIGINAL);
        return DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), IntPair.m7829getFirstimpl(m7771computeDstSizesEdh43o), IntPair.m7830getSecondimpl(m7771computeDstSizesEdh43o), scale) == 1.0d;
    }
}
