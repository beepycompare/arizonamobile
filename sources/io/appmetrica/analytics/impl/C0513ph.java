package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0513ph extends AbstractC0237eh {
    public C0513ph(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        Ek ek;
        Uk uk;
        F9 f9 = this.f831a.n;
        Sk sk = f9.c;
        if (sk.g == 0) {
            ek = sk.d.b();
            Ek b = sk.e.b();
            if ((ek == null ? -1L : ek.d) <= (b != null ? b.d : -1L)) {
                ek = b;
            }
        } else {
            ek = sk.f;
        }
        if (ek != null) {
            uk = new Uk();
            uk.f675a = ek.d;
            long andIncrement = ek.f.getAndIncrement();
            Vk vk = ek.b;
            vk.a(Vk.g, Long.valueOf(ek.f.get()));
            vk.b();
            uk.b = andIncrement;
            uk.c = TimeUnit.MILLISECONDS.toSeconds(ek.j);
            uk.d = ek.c.f475a;
        } else {
            long j = c0402l6.j;
            long a2 = sk.b.a();
            C0279g7 c0279g7 = sk.f642a.e;
            Wk wk = Wk.BACKGROUND;
            c0279g7.a(a2, wk, j);
            uk = new Uk();
            uk.f675a = a2;
            uk.d = wk;
            uk.b = 0L;
            uk.c = 0L;
        }
        f9.a(c0402l6, uk);
        return false;
    }
}
