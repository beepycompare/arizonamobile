package com.skydoves.cloudy.internals.render;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
/* compiled from: RenderScriptToolkit.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a,\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a,\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"externalName", "", "validateBitmap", "", "function", "inputBitmap", "Landroid/graphics/Bitmap;", "alphaAllowed", "", "createCompatibleBitmap", "validateRestriction", "tag", "sizeX", "", "sizeY", "restriction", "Lcom/skydoves/cloudy/internals/render/Range2d;", "vectorSize", "bitmap", "iterativeBlur", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CoroutineScope;", "androidBitmap", "outputBitmap", "radius", "cloudy_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RenderScriptToolkitKt {
    private static final String externalName = "RenderScript Toolkit";

    /* compiled from: RenderScriptToolkit.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void validateBitmap$default(String str, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        validateBitmap(str, bitmap, z);
    }

    public static final void validateBitmap(String function, Bitmap inputBitmap, boolean z) {
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        if (z) {
            if (inputBitmap.getConfig() != Bitmap.Config.ARGB_8888 && inputBitmap.getConfig() != Bitmap.Config.ALPHA_8) {
                throw new IllegalArgumentException(("RenderScript Toolkit. " + function + " supports only ARGB_8888 and ALPHA_8 bitmaps. " + inputBitmap.getConfig() + " provided.").toString());
            }
        } else if (inputBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException(("RenderScript Toolkit. " + function + " supports only ARGB_8888. " + inputBitmap.getConfig() + " provided.").toString());
        }
        if (inputBitmap.getWidth() * vectorSize(inputBitmap) != inputBitmap.getRowBytes()) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + function + ". Only bitmaps with rowSize equal to the width * vectorSize are currently supported. Provided were rowBytes=" + inputBitmap.getRowBytes() + ", width={" + inputBitmap.getWidth() + ", and vectorSize=" + vectorSize(inputBitmap) + '.').toString());
        }
    }

    public static final Bitmap createCompatibleBitmap(Bitmap inputBitmap) {
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        int width = inputBitmap.getWidth();
        int height = inputBitmap.getHeight();
        Bitmap.Config config = inputBitmap.getConfig();
        Intrinsics.checkNotNull(config);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static /* synthetic */ void validateRestriction$default(String str, int i, int i2, Range2d range2d, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            range2d = null;
        }
        validateRestriction(str, i, i2, range2d);
    }

    public static final void validateRestriction(String tag, int i, int i2, Range2d range2d) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (range2d == null) {
            return;
        }
        if (range2d.getStartX() >= i || range2d.getEndX() > i) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". sizeX should be greater than restriction.startX and greater or equal to restriction.endX. " + i + ", " + range2d.getStartX() + ", and " + range2d.getEndX() + " were provided respectively.").toString());
        }
        if (range2d.getStartY() >= i2 || range2d.getEndY() > i2) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". sizeY should be greater than restriction.startY and greater or equal to restriction.endY. " + i2 + ", " + range2d.getStartY() + ", and " + range2d.getEndY() + " were provided respectively.").toString());
        }
        if (range2d.getStartX() >= range2d.getEndX()) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". Restriction startX should be less than endX. " + range2d.getStartX() + " and " + range2d.getEndX() + " were provided respectively.").toString());
        }
        if (range2d.getStartY() >= range2d.getEndY()) {
            throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". Restriction startY should be less than endY. " + range2d.getStartY() + " and " + range2d.getEndY() + " were provided respectively.").toString());
        }
    }

    public static final int vectorSize(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        int i = config == null ? -1 : WhenMappings.$EnumSwitchMapping$0[config.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new IllegalArgumentException("RenderScript Toolkit. Only ARGB_8888 and ALPHA_8 Bitmap are supported.");
        }
        return 4;
    }

    public static final Deferred<Bitmap> iterativeBlur(CoroutineScope coroutineScope, Bitmap androidBitmap, Bitmap outputBitmap, int i) {
        Deferred<Bitmap> async$default;
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(androidBitmap, "androidBitmap");
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RenderScriptToolkitKt$iterativeBlur$1(i, androidBitmap, outputBitmap, null), 3, null);
        return async$default;
    }
}
