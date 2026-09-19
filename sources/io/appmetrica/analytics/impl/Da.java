package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class Da extends Q4 {
    public Da(N4 n4) {
        super(n4);
    }

    @Override // io.appmetrica.analytics.impl.Q4
    public final boolean a(C0240f6 c0240f6, L4 l4) {
        Bundle bundle = c0240f6.m;
        C0685wb c0685wb = bundle != null ? (C0685wb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0685wb != null) {
            if (c0685wb.d) {
                F4 f4 = l4.b.d.f781a;
                Boolean bool = f4.n;
                Boolean bool2 = f4.i;
                Na.I.c().c(bool != null ? bool.booleanValue() : true);
                Na.I.h().b(bool2);
            }
        }
        this.f727a.a(c0685wb);
        return false;
    }
}
