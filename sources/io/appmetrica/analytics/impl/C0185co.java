package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.co  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0185co extends AbstractC0358jh {
    public C0185co(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        String i = this.f925a.c.i();
        String str = c0399l6.h;
        this.f925a.c.j(str).b();
        if (TextUtils.equals(i, str)) {
            return false;
        }
        this.f925a.a(C0320i4.o());
        return false;
    }
}
