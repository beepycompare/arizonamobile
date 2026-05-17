package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0270ga extends A4 {
    public C0270ga(C0691x4 c0691x4) {
        super(c0691x4);
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final boolean a(P5 p5, C0616u4 c0616u4) {
        Bundle bundle = p5.m;
        Xa xa = bundle != null ? (Xa) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (xa != null) {
            if (xa.d) {
                C0467o4 c0467o4 = c0616u4.b.d.f1340a;
                Boolean bool = c0467o4.n;
                Boolean bool2 = c0467o4.i;
                C0448na.I.c().c(bool != null ? bool.booleanValue() : true);
                C0448na.I.h().b(bool2);
            }
        }
        this.f498a.a(xa);
        return false;
    }
}
