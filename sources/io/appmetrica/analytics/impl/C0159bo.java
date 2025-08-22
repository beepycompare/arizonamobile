package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0159bo extends V4 {
    public final C0116a7 b;

    public C0159bo(S4 s4, C0116a7 c0116a7) {
        super(s4);
        this.b = c0116a7;
    }

    @Override // io.appmetrica.analytics.impl.V4
    public final boolean a(C0399l6 c0399l6, P4 p4) {
        J4 j4 = p4.b.d.f637a;
        this.b.a(j4.i);
        InterfaceC0302hc l = Ka.F.l();
        if (Boolean.TRUE.equals(j4.b)) {
            l.a(true);
        } else {
            if (Boolean.FALSE.equals(j4.b)) {
                l.a(false);
            }
        }
        l.a(j4.c);
        Boolean bool = j4.n;
        Ka.F.b().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
