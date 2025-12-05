package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0292ha extends B4 {
    public C0292ha(C0713y4 c0713y4) {
        super(c0713y4);
    }

    @Override // io.appmetrica.analytics.impl.B4
    public final boolean a(Q5 q5, C0638v4 c0638v4) {
        Bundle bundle = q5.m;
        Ya ya = bundle != null ? (Ya) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (ya != null) {
            if (ya.d) {
                C0489p4 c0489p4 = c0638v4.b.d.f481a;
                Boolean bool = c0489p4.n;
                Boolean bool2 = c0489p4.i;
                C0470oa.I.c().c(bool != null ? bool.booleanValue() : true);
                C0470oa.I.h().b(bool2);
            }
        }
        this.f488a.a(ya);
        return false;
    }
}
