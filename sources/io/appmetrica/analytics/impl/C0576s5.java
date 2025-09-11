package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.s5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0576s5 extends AbstractC0551r5 {
    public C0576s5(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0551r5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0551r5
    public final void c() {
        C0537qf c0537qf = this.f1061a.c;
        try {
            C0233el c0233el = new C0233el(c0537qf, O2.g);
            Long a2 = c0233el.c.a(C0233el.d);
            if (a2 != null) {
                c0233el.a(C0233el.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = c0233el.c.a(C0233el.e);
            if (a3 != null) {
                c0233el.a(C0233el.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0233el c0233el2 = new C0233el(c0537qf, "foreground");
            Long a4 = c0233el2.c.a(C0233el.d);
            if (a4 != null) {
                c0233el2.a(C0233el.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = c0233el2.c.a(C0233el.e);
            if (a5 != null) {
                c0233el2.a(C0233el.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
