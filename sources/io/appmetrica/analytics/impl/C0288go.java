package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.go  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288go extends AbstractC0462nh {
    public C0288go(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        String j = this.f1005a.c.j();
        String str = c0477o6.h;
        this.f1005a.c.j(str).b();
        if (TextUtils.equals(j, str)) {
            return false;
        }
        this.f1005a.a(C0397l4.o());
        return false;
    }
}
