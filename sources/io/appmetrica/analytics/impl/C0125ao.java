package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0125ao extends B4 {
    public final F6 b;

    public C0125ao(C0713y4 c0713y4, F6 f6) {
        super(c0713y4);
        this.b = f6;
    }

    @Override // io.appmetrica.analytics.impl.B4
    public final boolean a(Q5 q5, C0638v4 c0638v4) {
        C0489p4 c0489p4 = c0638v4.b.d.f496a;
        this.b.a(c0489p4.i);
        Lb m = C0470oa.I.m();
        if (Boolean.TRUE.equals(c0489p4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(c0489p4.b)) {
                m.a(false);
            }
        }
        m.a(c0489p4.c);
        Boolean bool = c0489p4.n;
        C0470oa.I.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
