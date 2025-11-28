package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0152bo extends H4 {
    public final L6 b;

    public C0152bo(E4 e4, L6 l6) {
        super(e4);
        this.b = l6;
    }

    @Override // io.appmetrica.analytics.impl.H4
    public final boolean a(W5 w5, B4 b4) {
        C0639v4 c0639v4 = b4.b.d.f461a;
        this.b.a(c0639v4.i);
        Rb m = C0620ua.H.m();
        if (Boolean.TRUE.equals(c0639v4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(c0639v4.b)) {
                m.a(false);
            }
        }
        m.a(c0639v4.c);
        Boolean bool = c0639v4.n;
        C0620ua.H.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
