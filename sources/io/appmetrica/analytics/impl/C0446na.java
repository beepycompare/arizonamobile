package io.appmetrica.analytics.impl;

import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.na  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0446na extends H4 {
    public C0446na(E4 e4) {
        super(e4);
    }

    @Override // io.appmetrica.analytics.impl.H4
    public final boolean a(W5 w5, B4 b4) {
        Bundle bundle = w5.m;
        C0216eb c0216eb = bundle != null ? (C0216eb) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null;
        if (c0216eb != null) {
            if (c0216eb.d) {
                C0639v4 c0639v4 = b4.b.d.f461a;
                Boolean bool = c0639v4.n;
                Boolean bool2 = c0639v4.i;
                C0620ua.H.c().c(bool != null ? bool.booleanValue() : true);
                C0620ua.H.h().b(bool2);
            }
        }
        this.f501a.a(c0216eb);
        return false;
    }
}
