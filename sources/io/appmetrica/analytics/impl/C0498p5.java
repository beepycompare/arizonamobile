package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.p5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0498p5 extends AbstractC0473o5 {
    public C0498p5(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0473o5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0473o5
    public final void c() {
        Cif cif = this.f968a.c;
        try {
            Sk sk = new Sk(cif, L2.g);
            Long a2 = sk.c.a(Sk.d);
            if (a2 != null) {
                sk.a(Sk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = sk.c.a(Sk.e);
            if (a3 != null) {
                sk.a(Sk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            Sk sk2 = new Sk(cif, "foreground");
            Long a4 = sk2.c.a(Sk.d);
            if (a4 != null) {
                sk2.a(Sk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = sk2.c.a(Sk.e);
            if (a5 != null) {
                sk2.a(Sk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
