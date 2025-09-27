package ru.mrlargha.commonui.elements.items3d;

import android.app.Activity;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: listener.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"positionModelCentered", "Lru/mrlargha/commonui/elements/items3d/Position;", "activity", "Landroid/app/Activity;", "percentHeight", "", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ListenerKt {
    public static final Position positionModelCentered(Activity activity, float f) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = (int) (i2 * f);
        int i4 = (int) (i3 * 1.5f);
        if (i4 > i) {
            i3 = (int) (i / 1.5f);
            i4 = i;
        }
        int i5 = (i - i4) / 2;
        int i6 = (i2 - i3) / 2;
        return new Position(i2, i, 0, 0);
    }
}
