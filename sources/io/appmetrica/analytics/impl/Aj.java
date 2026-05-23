package io.appmetrica.analytics.impl;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* loaded from: classes5.dex */
public final class Aj implements FunctionWithThrowable {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Display) obj).getRealMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
