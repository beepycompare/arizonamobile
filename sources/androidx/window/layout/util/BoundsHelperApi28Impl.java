package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoundsHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi28Impl;", "Landroidx/window/layout/util/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BoundsHelperApi28Impl implements BoundsHelper {
    public static final BoundsHelperApi28Impl INSTANCE = new BoundsHelperApi28Impl();

    private BoundsHelperApi28Impl() {
    }

    @Override // androidx.window.layout.util.BoundsHelper
    public Rect currentWindowBounds(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                Intrinsics.checkNotNull(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (Exception e) {
            if ((e instanceof NoSuchFieldException) || (e instanceof NoSuchMethodException) || (e instanceof IllegalAccessException) || (e instanceof InvocationTargetException)) {
                Log.w(BoundsHelper.Companion.getTAG(), e);
                BoundsHelperKt.access$getRectSizeFromDisplay(activity, rect);
            } else {
                throw e;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            int access$getNavigationBarHeight = BoundsHelperKt.access$getNavigationBarHeight(activity);
            if (rect.bottom + access$getNavigationBarHeight == point.y) {
                rect.bottom += access$getNavigationBarHeight;
            } else if (rect.right + access$getNavigationBarHeight == point.x) {
                rect.right += access$getNavigationBarHeight;
            } else if (rect.left == access$getNavigationBarHeight) {
                rect.left = 0;
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            Intrinsics.checkNotNull(defaultDisplay);
            DisplayCutout access$getCutoutForDisplay = BoundsHelperKt.access$getCutoutForDisplay(defaultDisplay);
            if (access$getCutoutForDisplay != null) {
                if (rect.left == DisplayCompatHelperApi28.INSTANCE.safeInsetLeft(access$getCutoutForDisplay)) {
                    rect.left = 0;
                }
                if (point.x - rect.right == DisplayCompatHelperApi28.INSTANCE.safeInsetRight(access$getCutoutForDisplay)) {
                    rect.right += DisplayCompatHelperApi28.INSTANCE.safeInsetRight(access$getCutoutForDisplay);
                }
                if (rect.top == DisplayCompatHelperApi28.INSTANCE.safeInsetTop(access$getCutoutForDisplay)) {
                    rect.top = 0;
                }
                if (point.y - rect.bottom == DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(access$getCutoutForDisplay)) {
                    rect.bottom += DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(access$getCutoutForDisplay);
                }
            }
        }
        return rect;
    }

    @Override // androidx.window.layout.util.BoundsHelper
    public Rect maximumWindowBounds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BoundsHelperApi24Impl.INSTANCE.maximumWindowBounds(context);
    }
}
