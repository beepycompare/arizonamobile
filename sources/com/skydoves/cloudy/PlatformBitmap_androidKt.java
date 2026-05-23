package com.skydoves.cloudy;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformBitmap.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0001¨\u0006\u0007"}, d2 = {"createCompatible", "Lcom/skydoves/cloudy/PlatformBitmap;", "dispose", "", "toPlatformBitmap", "Landroid/graphics/Bitmap;", "toAndroidBitmap", "cloudy_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlatformBitmap_androidKt {
    public static final PlatformBitmap createCompatible(PlatformBitmap platformBitmap) {
        Intrinsics.checkNotNullParameter(platformBitmap, "<this>");
        int width = platformBitmap.getWidth();
        int height = platformBitmap.getHeight();
        Bitmap.Config config = platformBitmap.getBitmap().getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return new PlatformBitmap(createBitmap);
    }

    public static final void dispose(PlatformBitmap platformBitmap) {
        Intrinsics.checkNotNullParameter(platformBitmap, "<this>");
        if (platformBitmap.getBitmap().isRecycled()) {
            return;
        }
        platformBitmap.getBitmap().recycle();
    }

    public static final PlatformBitmap toPlatformBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return new PlatformBitmap(bitmap);
    }

    public static final Bitmap toAndroidBitmap(PlatformBitmap platformBitmap) {
        Intrinsics.checkNotNullParameter(platformBitmap, "<this>");
        return platformBitmap.getBitmap();
    }
}
