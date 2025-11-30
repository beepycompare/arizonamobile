package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Wi extends Sg {
    public Wi(Y4 y4) {
        super(y4);
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        String str = q5.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f679a.c.j(str).b();
        return false;
    }
}
