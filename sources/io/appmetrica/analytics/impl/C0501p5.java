package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.p5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0501p5 extends AbstractC0476o5 {
    public C0501p5(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0476o5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0476o5
    public final void c() {
        C0386kf c0386kf = this.f981a.c;
        try {
            Vk vk = new Vk(c0386kf, L2.g);
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
            Vk vk2 = new Vk(c0386kf, "foreground");
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
