package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
/* compiled from: FocusInteropUtils.android.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u001a%\u0010\u0015\u001a\u00020\u0016*\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"tempCoordinates", "", "tempRect", "Landroid/graphics/Rect;", "toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateFocusRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInteropUtils_androidKt {
    private static final int[] tempCoordinates = new int[2];
    private static final Rect tempRect = new Rect();

    public static final FocusDirection toFocusDirection(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                return null;
                            }
                            return FocusDirection.m5051boximpl(FocusDirection.Companion.m5058getDowndhqQ8s());
                        }
                        return FocusDirection.m5051boximpl(FocusDirection.Companion.m5064getRightdhqQ8s());
                    }
                    return FocusDirection.m5051boximpl(FocusDirection.Companion.m5065getUpdhqQ8s());
                }
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5061getLeftdhqQ8s());
            }
            return FocusDirection.m5051boximpl(FocusDirection.Companion.m5062getNextdhqQ8s());
        }
        return FocusDirection.m5051boximpl(FocusDirection.Companion.m5063getPreviousdhqQ8s());
    }

    /* renamed from: toAndroidFocusDirection-3ESFkO8  reason: not valid java name */
    public static final Integer m5066toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5065getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5058getDowndhqQ8s())) {
            return Integer.valueOf((int) TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5061getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5064getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5062getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m5054equalsimpl0(i, FocusDirection.Companion.m5063getPreviousdhqQ8s()) ? 1 : null;
    }

    /* renamed from: toFocusDirection-ZmokQxo  reason: not valid java name */
    public static final FocusDirection m5067toFocusDirectionZmokQxo(KeyEvent keyEvent) {
        long m6587getKeyZmokQxo = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6439getNavigatePreviousEK5gGoQ())) {
            return FocusDirection.m5051boximpl(FocusDirection.Companion.m5063getPreviousdhqQ8s());
        }
        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6437getNavigateNextEK5gGoQ())) {
            return FocusDirection.m5051boximpl(FocusDirection.Companion.m5062getNextdhqQ8s());
        }
        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6515getTabEK5gGoQ())) {
            return FocusDirection.m5051boximpl(KeyEvent_androidKt.m6593isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m5063getPreviousdhqQ8s() : FocusDirection.Companion.m5062getNextdhqQ8s());
        } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6356getDirectionRightEK5gGoQ())) {
            return FocusDirection.m5051boximpl(FocusDirection.Companion.m5064getRightdhqQ8s());
        } else {
            if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6355getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5061getLeftdhqQ8s());
            }
            if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6357getDirectionUpEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6468getPageUpEK5gGoQ())) {
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5065getUpdhqQ8s());
            }
            if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6352getDirectionDownEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6467getPageDownEK5gGoQ())) {
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5058getDowndhqQ8s());
            }
            if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6351getDirectionCenterEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6365getEnterEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6457getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5059getEnterdhqQ8s());
            }
            if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6294getBackEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6368getEscapeEK5gGoQ())) {
                return FocusDirection.m5051boximpl(FocusDirection.Companion.m5060getExitdhqQ8s());
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

    public static final androidx.compose.ui.geometry.Rect calculateFocusRectRelativeTo(View view, View view2) {
        Rect rect;
        int[] iArr = tempCoordinates;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        float f = i - iArr[0];
        float f2 = i2 - iArr[1];
        view.getFocusedRect(tempRect);
        return new androidx.compose.ui.geometry.Rect(rect.left + f, rect.top + f2, f + rect.left + rect.width(), f2 + rect.top + rect.height());
    }

    public static final boolean requestInteropFocus(View view, Integer num, Rect rect) {
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
