package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Q5 extends AbstractC0592t4 {
    public Q5(String str, double d) {
        super(2, str, Double.valueOf(d), new C0525qb(), new C0567s4(new Gb(new C0418m4(100))));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0592t4
    public final void a(C0259fo c0259fo) {
        C0311ho c0311ho = c0259fo.d;
        c0311ho.c = ((Double) this.f).doubleValue() + c0311ho.c;
    }
}
