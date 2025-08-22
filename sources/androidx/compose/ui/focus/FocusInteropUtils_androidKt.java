package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
/* compiled from: FocusInteropUtils.android.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a%\u0010\u0011\u001a\u00020\u0012*\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
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
                            return FocusDirection.m4169boximpl(FocusDirection.Companion.m4176getDowndhqQ8s());
                        }
                        return FocusDirection.m4169boximpl(FocusDirection.Companion.m4182getRightdhqQ8s());
                    }
                    return FocusDirection.m4169boximpl(FocusDirection.Companion.m4183getUpdhqQ8s());
                }
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4179getLeftdhqQ8s());
            }
            return FocusDirection.m4169boximpl(FocusDirection.Companion.m4180getNextdhqQ8s());
        }
        return FocusDirection.m4169boximpl(FocusDirection.Companion.m4181getPreviousdhqQ8s());
    }

    /* renamed from: toAndroidFocusDirection-3ESFkO8  reason: not valid java name */
    public static final Integer m4184toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4183getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4176getDowndhqQ8s())) {
            return Integer.valueOf((int) TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4179getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4182getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4180getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m4172equalsimpl0(i, FocusDirection.Companion.m4181getPreviousdhqQ8s()) ? 1 : null;
    }

    /* renamed from: toFocusDirection-ZmokQxo  reason: not valid java name */
    public static final FocusDirection m4185toFocusDirectionZmokQxo(KeyEvent keyEvent) {
        long m5682getKeyZmokQxo = KeyEvent_androidKt.m5682getKeyZmokQxo(keyEvent);
        if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5534getNavigatePreviousEK5gGoQ())) {
            return FocusDirection.m4169boximpl(FocusDirection.Companion.m4181getPreviousdhqQ8s());
        }
        if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5532getNavigateNextEK5gGoQ())) {
            return FocusDirection.m4169boximpl(FocusDirection.Companion.m4180getNextdhqQ8s());
        }
        if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5610getTabEK5gGoQ())) {
            return FocusDirection.m4169boximpl(KeyEvent_androidKt.m5688isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m4181getPreviousdhqQ8s() : FocusDirection.Companion.m4180getNextdhqQ8s());
        } else if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5451getDirectionRightEK5gGoQ())) {
            return FocusDirection.m4169boximpl(FocusDirection.Companion.m4182getRightdhqQ8s());
        } else {
            if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5450getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4179getLeftdhqQ8s());
            }
            if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5452getDirectionUpEK5gGoQ()) || Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5563getPageUpEK5gGoQ())) {
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4183getUpdhqQ8s());
            }
            if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5447getDirectionDownEK5gGoQ()) || Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5562getPageDownEK5gGoQ())) {
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4176getDowndhqQ8s());
            }
            if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5446getDirectionCenterEK5gGoQ()) || Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5460getEnterEK5gGoQ()) || Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5552getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4177getEnterdhqQ8s());
            }
            if (Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5389getBackEK5gGoQ()) || Key.m5374equalsimpl0(m5682getKeyZmokQxo, Key.Companion.m5463getEscapeEK5gGoQ())) {
                return FocusDirection.m4169boximpl(FocusDirection.Companion.m4178getExitdhqQ8s());
            }
            return null;
        }
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
            if (!viewGroup.isFocusable() || viewGroup.hasFocus()) {
                if (view instanceof AndroidComposeView) {
                    return ((AndroidComposeView) view).requestFocus(num.intValue(), rect);
                }
                if (rect != null) {
                    View findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
                    return findNextFocusFromRect != null ? findNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
                return findNextFocus != null ? findNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
            }
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        return view.requestFocus(num.intValue(), rect);
    }
}
