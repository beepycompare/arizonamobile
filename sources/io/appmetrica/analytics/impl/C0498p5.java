package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.p5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0498p5 extends AbstractC0473o5 {
    public C0498p5(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0473o5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0473o5
    public final void c() {
        C0433mf c0433mf = this.f995a.c;
        try {
            C0130al c0130al = new C0130al(c0433mf, L2.g);
            Long a2 = c0130al.c.a(C0130al.d);
            if (a2 != null) {
                c0130al.a(C0130al.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a2.longValue())));
            }
            Long a3 = c0130al.c.a(C0130al.e);
            if (a3 != null) {
                c0130al.a(C0130al.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a3.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C0130al c0130al2 = new C0130al(c0433mf, "foreground");
            Long a4 = c0130al2.c.a(C0130al.d);
            if (a4 != null) {
                c0130al2.a(C0130al.d, Long.valueOf(TimeUnit.SECONDS.toMillis(a4.longValue())));
            }
            Long a5 = c0130al2.c.a(C0130al.e);
            if (a5 != null) {
                c0130al2.a(C0130al.e, Long.valueOf(TimeUnit.SECONDS.toMillis(a5.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
