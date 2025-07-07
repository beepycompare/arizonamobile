package androidx.transition;

import android.view.View;
/* loaded from: classes3.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @Override // androidx.transition.ViewUtilsApi19
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
            view.setLeftTopRightBottom(i, i2, i3, i4);
        }
    }
}
