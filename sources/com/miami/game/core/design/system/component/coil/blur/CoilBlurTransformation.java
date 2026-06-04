package com.miami.game.core.design.system.component.coil.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.MotionEventCompat;
import coil3.size.Size;
import coil3.transform.Transformation;
import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: blur.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/design/system/component/coil/blur/CoilBlurTransformation;", "Lcoil3/transform/Transformation;", "radius", "", "sampling", "<init>", "(II)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "transform", "Landroid/graphics/Bitmap;", "input", "size", "Lcoil3/size/Size;", "(Landroid/graphics/Bitmap;Lcoil3/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stackBlur", "sentBitmap", "design-system", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CoilBlurTransformation extends Transformation {
    public static final int $stable = 8;
    private final String cacheKey;
    private final int radius;
    private final int sampling;

    public CoilBlurTransformation() {
        this(0, 0, 3, null);
    }

    public CoilBlurTransformation(int i, int i2) {
        this.radius = i;
        this.sampling = i2;
        this.cacheKey = "coil-blur-" + i + Constants.FILENAME_SEQUENCE_SEPARATOR + i2;
    }

    public /* synthetic */ CoilBlurTransformation(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? 2 : i2);
    }

    @Override // coil3.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil3.transform.Transformation
    public Object transform(Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() / this.sampling, bitmap.getHeight() / this.sampling, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        int i = this.sampling;
        canvas.scale(1.0f / i, 1.0f / i);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return stackBlur(createBitmap, this.radius);
    }

    private final Bitmap stackBlur(Bitmap bitmap, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = i;
        boolean z2 = true;
        if (i6 < 1) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i7 = width * height;
        int[] iArr = new int[i7];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i8 = i6 + i6 + 1;
        int[] iArr2 = new int[i7];
        int[] iArr3 = new int[i7];
        int[] iArr4 = new int[i7];
        int[] iArr5 = new int[Math.max(width, height)];
        int i9 = i8 * 256;
        int[] iArr6 = new int[i9];
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            iArr6[i11] = i11 / i8;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = -i6;
            if (i15 <= i6) {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                while (true) {
                    z = z2;
                    i2 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                    int i16 = iArr[Math.min(width - 1, Math.max(i15, 0)) + i13];
                    i3 += (i16 & 16711680) >> 16;
                    i4 += (i16 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    i5 += i16 & 255;
                    if (i15 == i6) {
                        break;
                    }
                    i15++;
                    z2 = z;
                }
            } else {
                z = z2;
                i2 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            for (int i17 = 0; i17 < width; i17++) {
                iArr2[i13] = iArr6[i3];
                iArr3[i13] = iArr6[i4];
                iArr4[i13] = iArr6[i5];
                if (i12 == 0) {
                    iArr5[i17] = Math.min(i17 + i6 + 1, width - 1);
                }
                int i18 = iArr[iArr5[i17] + i14];
                int i19 = iArr[Math.max(i17 - i6, 0) + i14];
                i3 += ((i18 & 16711680) - (i19 & 16711680)) >> 16;
                i4 += ((i18 & i2) - (i19 & i2)) >> 8;
                i5 += (i18 & 255) - (i19 & 255);
                i13++;
            }
            i14 += width;
            i12++;
            z2 = z;
        }
        int i20 = 0;
        while (i20 < width) {
            int i21 = -i6;
            int i22 = i21 * width;
            int i23 = i10;
            int i24 = i23;
            int i25 = i24;
            if (i21 <= i6) {
                while (true) {
                    int max = Math.max(i10, i22) + i20;
                    i23 += iArr2[max];
                    i24 += iArr3[max];
                    i25 += iArr4[max];
                    i22 += width;
                    if (i21 == i6) {
                        break;
                    }
                    i21++;
                }
            }
            int i26 = i20;
            int i27 = i10;
            while (i27 < height) {
                iArr[i26] = (iArr6[i23] << 16) | (-16777216) | (iArr6[i24] << 8) | iArr6[i25];
                if (i20 == 0) {
                    iArr5[i27] = Math.min(i27 + i6 + 1, height - 1) * width;
                }
                int i28 = iArr5[i27] + i20;
                int max2 = (Math.max(i27 - i, 0) * width) + i20;
                i23 += iArr2[i28] - iArr2[max2];
                i24 += iArr3[i28] - iArr3[max2];
                i25 += iArr4[i28] - iArr4[max2];
                i26 += width;
                i27++;
                i10 = 0;
                i6 = i;
            }
            i20++;
            i6 = i;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
