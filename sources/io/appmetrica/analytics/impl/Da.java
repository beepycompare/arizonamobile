package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes5.dex */
public final class Da extends Q4 {
    public Da(N4 n4) {
        super(n4);
    }

    @Override // io.appmetrica.analytics.impl.Q4
    public final boolean a(C0235f6 c0235f6, L4 l4) {
        Bundle bundle = c0235f6.m;
        C0680wb c0680wb = bundle != null ? (C0680wb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0680wb != null) {
            if (c0680wb.d) {
                F4 f4 = l4.b.d.f784a;
                Boolean bool = f4.n;
                Boolean bool2 = f4.i;
                Na.I.c().c(bool != null ? bool.booleanValue() : true);
                Na.I.h().b(bool2);
            }
        }
        this.f730a.a(c0680wb);
        return false;
    }
}
