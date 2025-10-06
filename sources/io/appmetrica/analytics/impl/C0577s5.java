package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.s5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0577s5 extends AbstractC0552r5 {
    public C0577s5(C0652v5 c0652v5) {
        super(c0652v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0552r5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0552r5
    public final void c() {
        C0538qf c0538qf = this.f1062a.c;
        try {
            C0234el c0234el = new C0234el(c0538qf, O2.g);
            Long a2 = c0234el.c.a(C0234el.d);
            if (a2 != null) {
                c0234el.a(C0234el.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = c0234el.c.a(C0234el.e);
            if (a3 != null) {
                c0234el.a(C0234el.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0234el c0234el2 = new C0234el(c0538qf, "foreground");
            Long a4 = c0234el2.c.a(C0234el.d);
            if (a4 != null) {
                c0234el2.a(C0234el.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = c0234el2.c.a(C0234el.e);
            if (a5 != null) {
                c0234el2.a(C0234el.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
