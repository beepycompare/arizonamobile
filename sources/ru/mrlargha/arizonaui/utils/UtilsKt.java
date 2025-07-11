package ru.mrlargha.arizonaui.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0002H\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"applyIf", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setImage", "imageView", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "ArizonaUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final <T> T applyIf(T t, Function1<? super T, Boolean> predicate, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(block, "block");
        if (predicate.invoke(t).booleanValue()) {
            block.invoke(t);
        }
        return t;
    }

    public static final void setImage(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        imageView.setImageBitmap(Bitmap.createBitmap(bitmap));
    }
}
