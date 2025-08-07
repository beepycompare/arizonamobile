package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wn extends V4 {
    public final Z6 b;

    public Wn(S4 s4, Z6 z6) {
        super(s4);
        this.b = z6;
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0402l6 c0402l6, P4 p4) {
        J4 j4 = p4.b.d.f549a;
        this.b.a(j4.i);
        InterfaceC0258fc l = Ia.F.l();
        if (Boolean.TRUE.equals(j4.b)) {
            l.a(true);
        } else {
            if (Boolean.FALSE.equals(j4.b)) {
                l.a(false);
            }
        }
        l.a(j4.c);
        Boolean bool = j4.n;
        Ia.F.b().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
