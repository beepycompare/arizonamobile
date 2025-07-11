package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Tn extends V4 {
    public final W6 b;

    public Tn(S4 s4, W6 w6) {
        super(s4);
        this.b = w6;
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0325i6 c0325i6, P4 p4) {
        J4 j4 = p4.b.d.f507a;
        this.b.a(j4.i);
        InterfaceC0206dc l = Ga.F.l();
        if (Boolean.TRUE.equals(j4.b)) {
            l.a(true);
        } else {
            if (Boolean.FALSE.equals(j4.b)) {
                l.a(false);
            }
        }
        l.a(j4.c);
        Boolean bool = j4.n;
        Ga.F.b().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
