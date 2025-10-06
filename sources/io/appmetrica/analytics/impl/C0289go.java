package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.go  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0289go extends AbstractC0463nh {
    public C0289go(C0652v5 c0652v5) {
        super(c0652v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        String j = this.f1006a.c.j();
        String str = c0478o6.h;
        this.f1006a.c.j(str).b();
        if (TextUtils.equals(j, str)) {
            return false;
        }
        this.f1006a.a(C0398l4.o());
        return false;
    }
}
