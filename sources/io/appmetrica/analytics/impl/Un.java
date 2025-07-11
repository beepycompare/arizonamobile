package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class Un extends AbstractC0185ch {
    public Un(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        String i = this.f786a.c.i();
        String str = c0325i6.h;
        this.f786a.c.j(str).b();
        if (TextUtils.equals(i, str)) {
            return false;
        }
        this.f786a.a(C0323i4.o());
        return false;
    }
}
