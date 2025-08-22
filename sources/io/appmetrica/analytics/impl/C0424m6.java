package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0424m6 extends O4 {
    public C0424m6(String str, double d) {
        super(2, str, Double.valueOf(d), new Nb(), new N4(new C0199dc(new H4(100))));
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(C0314ho c0314ho) {
        C0365jo c0365jo = c0314ho.d;
        c0365jo.c = ((Double) this.f).doubleValue() + c0365jo.c;
    }
}
