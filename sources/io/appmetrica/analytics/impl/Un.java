package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class Un extends AbstractC0193ch {
    public Un(C0580s5 c0580s5) {
        super(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        String i = this.f785a.c.i();
        String str = c0333i6.h;
        this.f785a.c.j(str).b();
        if (TextUtils.equals(i, str)) {
            return false;
        }
        this.f785a.a(C0331i4.o());
        return false;
    }
}
