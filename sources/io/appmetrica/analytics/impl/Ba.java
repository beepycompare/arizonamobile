package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Ba extends V4 {
    public Ba(S4 s4) {
        super(s4);
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0401l6 c0401l6, P4 p4) {
        Bundle bundle = c0401l6.m;
        C0580sb c0580sb = bundle != null ? (C0580sb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0580sb != null) {
            if (c0580sb.d) {
                J4 j4 = p4.b.d.f549a;
                Boolean bool = j4.n;
                Boolean bool2 = j4.i;
                Ia.F.b().c(bool != null ? bool.booleanValue() : true);
                Ia.F.g().b(bool2);
            }
        }
        this.f681a.a(c0580sb);
        return false;
    }
}
