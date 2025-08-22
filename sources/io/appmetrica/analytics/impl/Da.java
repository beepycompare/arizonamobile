package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Da extends V4 {
    public Da(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0399l6 c0399l6, P4 p4) {
        Bundle bundle = c0399l6.m;
        C0628ub c0628ub = bundle != null ? (C0628ub) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0628ub != null) {
            if (c0628ub.d) {
                J4 j4 = p4.b.d.f637a;
                Boolean bool = j4.n;
                Boolean bool2 = j4.i;
                Ka.F.b().c(bool != null ? bool.booleanValue() : true);
                Ka.F.g().b(bool2);
            }
        }
        this.f689a.a(c0628ub);
        return false;
    }
}
