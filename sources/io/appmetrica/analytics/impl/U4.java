package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class U4 extends T4 {
    public U4(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.T4
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.T4
    public final void c() {
        We we = this.f793a.c;
        try {
            Uk uk = new Uk(we, C0739z2.g);
            Long a2 = uk.c.a(Uk.d);
            if (a2 != null) {
                uk.a(Uk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = uk.c.a(Uk.e);
            if (a3 != null) {
                uk.a(Uk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            Uk uk2 = new Uk(we, "foreground");
            Long a4 = uk2.c.a(Uk.d);
            if (a4 != null) {
                uk2.a(Uk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = uk2.c.a(Uk.e);
            if (a5 != null) {
                uk2.a(Uk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
