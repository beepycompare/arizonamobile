package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.b5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0133b5 extends AbstractC0107a5 {
    public C0133b5(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0107a5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0107a5
    public final void c() {
        C0143bf c0143bf = this.f797a.c;
        try {
            Zk zk = new Zk(c0143bf, H2.g);
            Long a2 = zk.c.a(Zk.d);
            if (a2 != null) {
                zk.a(Zk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = zk.c.a(Zk.e);
            if (a3 != null) {
                zk.a(Zk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            Zk zk2 = new Zk(c0143bf, "foreground");
            Long a4 = zk2.c.a(Zk.d);
            if (a4 != null) {
                zk2.a(Zk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = zk2.c.a(Zk.e);
            if (a5 != null) {
                zk2.a(Zk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
