package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0293ha extends B4 {
    public C0293ha(C0714y4 c0714y4) {
        super(c0714y4);
    }

    @Override // io.appmetrica.analytics.impl.B4
    public final boolean a(Q5 q5, C0639v4 c0639v4) {
        Bundle bundle = q5.m;
        Ya ya = bundle != null ? (Ya) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (ya != null) {
            if (ya.d) {
                C0490p4 c0490p4 = c0639v4.b.d.f398a;
                Boolean bool = c0490p4.n;
                Boolean bool2 = c0490p4.i;
                C0471oa.I.c().c(bool != null ? bool.booleanValue() : true);
                C0471oa.I.h().b(bool2);
            }
        }
        this.f405a.a(ya);
        return false;
    }
}
