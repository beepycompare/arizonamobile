package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Bitmap.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086\n\u001a'\u0010\u000b\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\bH\u0086\n\u001a'\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086\b\u001a#\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0086\b\u001a7\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0086\n\u001a\u0015\u0010\u0018\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001bH\u0086\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"applyCanvas", "Landroid/graphics/Bitmap;", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "get", "", "x", "y", "set", "color", "scale", "width", "height", "filter", "", "createBitmap", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "colorSpace", "Landroid/graphics/ColorSpace;", "contains", TtmlNode.TAG_P, "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final int get(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return bitmap.getPixel(i, i2);
    }

    public static final void set(Bitmap bitmap, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        bitmap.setPixel(i, i2, i3);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        return createScaledBitmap;
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point p) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        int width = bitmap.getWidth();
        int i = p.x;
        return i >= 0 && i < width && p.y >= 0 && p.y < bitmap.getHeight();
    }

    public static final boolean contains(Bitmap bitmap, PointF p) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        return p.x >= 0.0f && p.x < ((float) bitmap.getWidth()) && p.y >= 0.0f && p.y < ((float) bitmap.getHeight());
    }
}
