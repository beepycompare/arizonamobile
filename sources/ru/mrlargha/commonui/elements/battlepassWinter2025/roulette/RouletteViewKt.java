package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RouletteView.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"dpToPx", "", "context", "Landroid/content/Context;", "dp", "", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteViewKt {
    public static final int dpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getResources().getConfiguration().smallestScreenWidthDp >= 600) {
            f *= 1.5f;
        }
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
