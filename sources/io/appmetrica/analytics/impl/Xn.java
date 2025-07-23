package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class Xn extends AbstractC0236eh {
    public Xn(C0574s5 c0574s5) {
        super(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        String i = this.f831a.c.i();
        String str = c0401l6.h;
        this.f831a.c.j(str).b();
        if (TextUtils.equals(i, str)) {
            return false;
        }
        this.f831a.a(C0325i4.o());
        return false;
    }
}
