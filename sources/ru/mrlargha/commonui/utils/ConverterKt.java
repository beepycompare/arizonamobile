package ru.mrlargha.commonui.utils;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: Converter.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001¨\u0006\r"}, d2 = {"dpToPx", "", "dp", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "", "pxToDp", "px", "intToByteArray", "", "value", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConverterKt {
    public static final int dpToPx(int i, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return MathKt.roundToInt(i * activity.getResources().getDisplayMetrics().density);
    }

    public static final int dpToPx(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(i * context.getResources().getDisplayMetrics().density);
    }

    public static final int dpToPx(float f, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return MathKt.roundToInt(f * activity.getResources().getDisplayMetrics().density);
    }

    public static final float pxToDp(float f, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return f / (activity.getResources().getDisplayMetrics().densityDpi / 160);
    }

    public static final byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) i};
    }
}
