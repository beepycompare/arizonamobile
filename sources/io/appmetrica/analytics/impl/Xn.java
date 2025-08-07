package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class Xn extends AbstractC0237eh {
    public Xn(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        String i = this.f831a.c.i();
        String str = c0402l6.h;
        this.f831a.c.j(str).b();
        if (TextUtils.equals(i, str)) {
            return false;
        }
        this.f831a.a(C0326i4.o());
        return false;
    }
}
