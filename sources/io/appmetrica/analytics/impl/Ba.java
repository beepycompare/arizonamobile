package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Ba extends V4 {
    public Ba(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0402l6 c0402l6, P4 p4) {
        Bundle bundle = c0402l6.m;
        C0581sb c0581sb = bundle != null ? (C0581sb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0581sb != null) {
            if (c0581sb.d) {
                J4 j4 = p4.b.d.f549a;
                Boolean bool = j4.n;
                Boolean bool2 = j4.i;
                Ia.F.b().c(bool != null ? bool.booleanValue() : true);
                Ia.F.g().b(bool2);
            }
        }
        this.f681a.a(c0581sb);
        return false;
    }
}
