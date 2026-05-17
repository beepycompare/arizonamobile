package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Zn extends A4 {
    public final E6 b;

    public Zn(C0691x4 c0691x4, E6 e6) {
        super(c0691x4);
        this.b = e6;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final boolean a(P5 p5, C0616u4 c0616u4) {
        C0467o4 c0467o4 = c0616u4.b.d.f1340a;
        this.b.a(c0467o4.i);
        Kb m = C0448na.I.m();
        if (Boolean.TRUE.equals(c0467o4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(c0467o4.b)) {
                m.a(false);
            }
        }
        m.a(c0467o4.c);
        Boolean bool = c0467o4.n;
        C0448na.I.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
