package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0368k5 extends AbstractC0342j5 {
    public C0368k5(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0342j5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0342j5
    public final void c() {
        C0689wf c0689wf = this.f1048a.c;
        try {
            C0773zl c0773zl = new C0773zl(c0689wf, M2.g);
            Long b = c0773zl.c.b(C0773zl.d);
            if (b != null) {
                c0773zl.a(C0773zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b.longValue())));
            }
            Long b2 = c0773zl.c.b(C0773zl.e);
            if (b2 != null) {
                c0773zl.a(C0773zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0773zl c0773zl2 = new C0773zl(c0689wf, "foreground");
            Long b3 = c0773zl2.c.b(C0773zl.d);
            if (b3 != null) {
                c0773zl2.a(C0773zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b3.longValue())));
            }
            Long b4 = c0773zl2.c.b(C0773zl.e);
            if (b4 != null) {
                c0773zl2.a(C0773zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
