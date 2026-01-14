package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Vi extends Rg {
    public Vi(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        String str = p5.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f768a.c.j(str).b();
        return false;
    }
}
