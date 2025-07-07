package androidx.compose.ui.platform;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import kotlin.Metadata;
/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelperApi16Impl;", "Landroidx/compose/ui/platform/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BoundsHelperApi16Impl implements BoundsHelper {
    public static final BoundsHelperApi16Impl INSTANCE = new BoundsHelperApi16Impl();

    private BoundsHelperApi16Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect currentWindowBounds(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Rect rect = new Rect();
        if (point.x == 0 || point.y == 0) {
            defaultDisplay.getRectSize(rect);
            return rect;
        }
        rect.right = point.x;
        rect.bottom = point.y;
        return rect;
    }
}
