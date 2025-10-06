package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Ga extends Y4 {
    public Ga(V4 v4) {
        super(v4);
    }

    @Override // io.appmetrica.analytics.impl.Y4
    public final boolean a(C0478o6 c0478o6, S4 s4) {
        Bundle bundle = c0478o6.m;
        C0708xb c0708xb = bundle != null ? (C0708xb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0708xb != null) {
            if (c0708xb.d) {
                M4 m4 = s4.b.d.f715a;
                Boolean bool = m4.n;
                Boolean bool2 = m4.i;
                Na.F.b().c(bool != null ? bool.booleanValue() : true);
                Na.F.g().b(bool2);
            }
        }
        this.f753a.a(c0708xb);
        return false;
    }
}
