package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class V4 extends U4 {
    public V4(Y4 y4) {
        super(y4);
    }

    @Override // io.appmetrica.analytics.impl.U4
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.U4
    public final void c() {
        Xe xe = this.f788a.c;
        try {
            Vk vk = new Vk(xe, A2.g);
            Long a2 = vk.c.a(Vk.d);
            if (a2 != null) {
                vk.a(Vk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = vk.c.a(Vk.e);
            if (a3 != null) {
                vk.a(Vk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            Vk vk2 = new Vk(xe, "foreground");
            Long a4 = vk2.c.a(Vk.d);
            if (a4 != null) {
                vk2.a(Vk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = vk2.c.a(Vk.e);
            if (a5 != null) {
                vk2.a(Vk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
