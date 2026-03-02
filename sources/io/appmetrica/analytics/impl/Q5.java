package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Q5 extends AbstractC0591t4 {
    public Q5(String str, double d) {
        super(2, str, Double.valueOf(d), new C0524qb(), new C0566s4(new Gb(new C0417m4(100))));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0591t4
    public final void a(C0258fo c0258fo) {
        C0310ho c0310ho = c0258fo.d;
        c0310ho.c = ((Double) this.f).doubleValue() + c0310ho.c;
    }
}
