package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0370k5 extends AbstractC0344j5 {
    public C0370k5(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0344j5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0344j5
    public final void c() {
        C0691wf c0691wf = this.f1048a.c;
        try {
            C0775zl c0775zl = new C0775zl(c0691wf, M2.g);
            Long b = c0775zl.c.b(C0775zl.d);
            if (b != null) {
                c0775zl.a(C0775zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b.longValue())));
            }
            Long b2 = c0775zl.c.b(C0775zl.e);
            if (b2 != null) {
                c0775zl.a(C0775zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0775zl c0775zl2 = new C0775zl(c0691wf, "foreground");
            Long b3 = c0775zl2.c.b(C0775zl.d);
            if (b3 != null) {
                c0775zl2.a(C0775zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b3.longValue())));
            }
            Long b4 = c0775zl2.c.b(C0775zl.e);
            if (b4 != null) {
                c0775zl2.a(C0775zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
