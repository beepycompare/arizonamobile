package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0271ga extends A4 {
    public C0271ga(C0692x4 c0692x4) {
        super(c0692x4);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final boolean a(P5 p5, C0617u4 c0617u4) {
        Bundle bundle = p5.m;
        Xa xa = bundle != null ? (Xa) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (xa != null) {
            if (xa.d) {
                C0468o4 c0468o4 = c0617u4.b.d.f1335a;
                Boolean bool = c0468o4.n;
                Boolean bool2 = c0468o4.i;
                C0449na.I.c().c(bool != null ? bool.booleanValue() : true);
                C0449na.I.h().b(bool2);
            }
        }
        this.f493a.a(xa);
        return false;
    }
}
