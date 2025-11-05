package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.co  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0178co extends Wg {
    public C0178co(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        String j = this.f744a.c.j();
        String str = w5.h;
        this.f744a.c.j(str).b();
        if (TextUtils.equals(j, str)) {
            return false;
        }
        this.f744a.a(U3.o());
        return false;
    }
}
