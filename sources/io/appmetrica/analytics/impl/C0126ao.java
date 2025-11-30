package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0126ao extends B4 {
    public final F6 b;

    public C0126ao(C0714y4 c0714y4, F6 f6) {
        super(c0714y4);
        this.b = f6;
    }

    @Override // io.appmetrica.analytics.impl.B4
    public final boolean a(Q5 q5, C0639v4 c0639v4) {
        C0490p4 c0490p4 = c0639v4.b.d.f398a;
        this.b.a(c0490p4.i);
        Lb m = C0471oa.I.m();
        if (Boolean.TRUE.equals(c0490p4.b)) {
            m.a(true);
        } else {
            if (Boolean.FALSE.equals(c0490p4.b)) {
                m.a(false);
            }
        }
        m.a(c0490p4.c);
        Boolean bool = c0490p4.n;
        C0471oa.I.c().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
