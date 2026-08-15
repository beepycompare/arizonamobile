package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Bo extends Q4 {
    public final W6 b;

    public Bo(N4 n4, W6 w6) {
        super(n4);
        this.b = w6;
    }

    @Override // io.appmetrica.analytics.impl.Q4
    public final boolean a(C0241f6 c0241f6, L4 l4) {
        F4 f4 = l4.b.d.f781a;
        this.b.a(f4.i);
        InterfaceC0428mc m = Na.I.m();
        if (Boolean.TRUE.equals(f4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(f4.b)) {
                m.a(false);
            }
        }
        m.a(f4.c);
        Boolean bool = f4.n;
        Na.I.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
