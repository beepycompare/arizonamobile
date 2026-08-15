package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0369k5 extends AbstractC0343j5 {
    public C0369k5(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0343j5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0343j5
    public final void c() {
        C0690wf c0690wf = this.f1048a.c;
        try {
            C0774zl c0774zl = new C0774zl(c0690wf, M2.g);
            Long b = c0774zl.c.b(C0774zl.d);
            if (b != null) {
                c0774zl.a(C0774zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b.longValue())));
            }
            Long b2 = c0774zl.c.b(C0774zl.e);
            if (b2 != null) {
                c0774zl.a(C0774zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0774zl c0774zl2 = new C0774zl(c0690wf, "foreground");
            Long b3 = c0774zl2.c.b(C0774zl.d);
            if (b3 != null) {
                c0774zl2.a(C0774zl.d, Long.valueOf(TimeUnit.SECONDS.toMillis(b3.longValue())));
            }
            Long b4 = c0774zl2.c.b(C0774zl.e);
            if (b4 != null) {
                c0774zl2.a(C0774zl.e, Long.valueOf(TimeUnit.SECONDS.toMillis(b4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
