package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Zn extends A4 {
    public final E6 b;

    public Zn(C0692x4 c0692x4, E6 e6) {
        super(c0692x4);
        this.b = e6;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final boolean a(P5 p5, C0617u4 c0617u4) {
        C0468o4 c0468o4 = c0617u4.b.d.f1335a;
        this.b.a(c0468o4.i);
        Kb m = C0449na.I.m();
        if (Boolean.TRUE.equals(c0468o4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(c0468o4.b)) {
                m.a(false);
            }
        }
        m.a(c0468o4.c);
        Boolean bool = c0468o4.n;
        C0449na.I.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
