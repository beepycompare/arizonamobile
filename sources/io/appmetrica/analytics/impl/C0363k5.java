package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0363k5 extends AbstractC0337j5 {
    public C0363k5(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0337j5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0337j5
    public final void c() {
        C0684wf c0684wf = this.f1051a.c;
        try {
            C0768zl c0768zl = new C0768zl(c0684wf, M2.g);
            Long b = c0768zl.c.b(C0768zl.d);
            if (b != null) {
                c0768zl.a(C0768zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b.longValue())));
            }
            Long b2 = c0768zl.c.b(C0768zl.e);
            if (b2 != null) {
                c0768zl.a(C0768zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0768zl c0768zl2 = new C0768zl(c0684wf, "foreground");
            Long b3 = c0768zl2.c.b(C0768zl.d);
            if (b3 != null) {
                c0768zl2.a(C0768zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b3.longValue())));
            }
            Long b4 = c0768zl2.c.b(C0768zl.e);
            if (b4 != null) {
                c0768zl2.a(C0768zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
