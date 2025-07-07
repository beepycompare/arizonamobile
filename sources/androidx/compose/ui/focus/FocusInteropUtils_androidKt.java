package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
/* compiled from: FocusInteropUtils.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a%\u0010\u000b\u001a\u00020\f*\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInteropUtils_androidKt {
    public static final FocusDirection toFocusDirection(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                return null;
                            }
                            return FocusDirection.m3718boximpl(FocusDirection.Companion.m3725getDowndhqQ8s());
                        }
                        return FocusDirection.m3718boximpl(FocusDirection.Companion.m3731getRightdhqQ8s());
                    }
                    return FocusDirection.m3718boximpl(FocusDirection.Companion.m3732getUpdhqQ8s());
                }
                return FocusDirection.m3718boximpl(FocusDirection.Companion.m3728getLeftdhqQ8s());
            }
            return FocusDirection.m3718boximpl(FocusDirection.Companion.m3729getNextdhqQ8s());
        }
        return FocusDirection.m3718boximpl(FocusDirection.Companion.m3730getPreviousdhqQ8s());
    }

    /* renamed from: toAndroidFocusDirection-3ESFkO8  reason: not valid java name */
    public static final Integer m3733toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3732getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3725getDowndhqQ8s())) {
            return Integer.valueOf((int) TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3728getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3731getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3729getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3730getPreviousdhqQ8s()) ? 1 : null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return LayoutDirection.Rtl;
        }
        return LayoutDirection.Ltr;
    }

    public static final Rect calculateBoundingRectRelativeTo(View view, View view2) {
        view.getLocationInWindow(FocusInteropUtils.Companion.getTempCoordinates());
        int i = FocusInteropUtils.Companion.getTempCoordinates()[0];
        int i2 = FocusInteropUtils.Companion.getTempCoordinates()[1];
        view2.getLocationInWindow(FocusInteropUtils.Companion.getTempCoordinates());
        float f = i - FocusInteropUtils.Companion.getTempCoordinates()[0];
        float f2 = i2 - FocusInteropUtils.Companion.getTempCoordinates()[1];
        return new Rect(f, f2, view.getWidth() + f, view.getHeight() + f2);
    }

    public static final boolean requestInteropFocus(View view, Integer num, android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isFocused()) {
                return true;
            }
            if ((!viewGroup.isFocusable() || view.hasFocus()) && !(view instanceof AndroidComposeView)) {
                if (rect != null) {
                    View findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
                    return findNextFocusFromRect != null ? findNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
                return findNextFocus != null ? findNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
            }
            return view.requestFocus(num.intValue(), rect);
        }
        return view.requestFocus(num.intValue(), rect);
    }
}
