package com.androidplot.util;

import android.graphics.RectF;
import com.androidplot.ui.Insets;
/* loaded from: classes3.dex */
public abstract class RectFUtils {
    public static boolean areIdentical(RectF rectF, RectF rectF2) {
        return rectF.left == rectF2.left && rectF.top == rectF2.top && rectF.right == rectF2.right && rectF.bottom == rectF2.bottom;
    }

    public static RectF applyInsets(RectF rectF, Insets insets) {
        return insets != null ? new RectF(rectF.left + insets.getLeft(), rectF.top + insets.getTop(), rectF.right - insets.getRight(), rectF.bottom - insets.getBottom()) : rectF;
    }

    public static RectF createFromEdges(float f, float f2, float f3, float f4) {
        boolean z = f <= f3;
        boolean z2 = f2 <= f4;
        float f5 = z ? f : f3;
        float f6 = z2 ? f2 : f4;
        if (z) {
            f = f3;
        }
        if (z2) {
            f2 = f4;
        }
        return new RectF(f5, f6, f, f2);
    }
}
