package com.androidplot.util;

import android.graphics.RectF;
/* loaded from: classes3.dex */
public class DisplayDimensions {
    private static final int ONE = 1;
    private static final RectF initRect = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
    public final RectF canvasRect;
    public final RectF marginatedRect;
    public final RectF paddedRect;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DisplayDimensions() {
        this(r0, r0, r0);
        RectF rectF = initRect;
    }

    public DisplayDimensions(RectF rectF, RectF rectF2, RectF rectF3) {
        this.canvasRect = rectF;
        this.marginatedRect = rectF2;
        this.paddedRect = rectF3;
    }
}
