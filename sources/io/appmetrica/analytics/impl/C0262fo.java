package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0262fo extends Y4 {
    public final C0194d7 b;

    public C0262fo(V4 v4, C0194d7 c0194d7) {
        super(v4);
        this.b = c0194d7;
    }

    @Override // io.appmetrica.analytics.impl.Y4
    public final boolean a(C0477o6 c0477o6, S4 s4) {
        M4 m4 = s4.b.d.f714a;
        this.b.a(m4.i);
        InterfaceC0379kc l = Na.F.l();
        if (Boolean.TRUE.equals(m4.b)) {
            l.a(true);
        } else {
            if (Boolean.FALSE.equals(m4.b)) {
                l.a(false);
            }
        }
        l.a(m4.c);
        Boolean bool = m4.n;
        Na.F.b().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
