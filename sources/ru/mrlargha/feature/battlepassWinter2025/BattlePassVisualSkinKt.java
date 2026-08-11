package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassVisualSkin.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\b\u0001\u0010\u0003\u001a\u00020\u0001:\u0002\b\u00042\f\b\u0001\u0010\u0005\u001a\u00020\u0001:\u0002\b\u0006H\u0001b\u0002\b\u0007¨\u0006\b"}, d2 = {"resolveBattlePassColor", "", "Landroid/content/Context;", "attribute", "Landroidx/annotation/AttrRes;", "fallback", "Landroidx/annotation/ColorRes;", "Landroidx/annotation/ColorInt;", "battle-pass"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassVisualSkinKt {
    public static final int resolveBattlePassColor(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return ContextCompat.getColor(context, i2);
        }
        if (typedValue.resourceId != 0) {
            return ContextCompat.getColor(context, typedValue.resourceId);
        }
        return typedValue.data;
    }
}
