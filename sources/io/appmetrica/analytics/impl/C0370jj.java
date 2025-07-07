package io.appmetrica.analytics.impl;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0370jj implements FunctionWithThrowable {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Display) obj).getRealMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
