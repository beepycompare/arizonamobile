package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class X5 extends A4 {
    public X5(String str, double d) {
        super(2, str, Double.valueOf(d), new C0696xb(), new C0739z4(new Nb(new C0589t4(100))));
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0307ho c0307ho) {
        C0358jo c0358jo = c0307ho.d;
        c0358jo.c = ((Double) this.f).doubleValue() + c0358jo.c;
    }
}
