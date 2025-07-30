package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0512ph extends AbstractC0236eh {
    public C0512ph(C0574s5 c0574s5) {
        super(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        Ek ek;
        Uk uk;
        F9 f9 = this.f832a.n;
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
            uk.f676a = ek.d;
            long andIncrement = ek.f.getAndIncrement();
            Vk vk = ek.b;
            vk.a(Vk.g, Long.valueOf(ek.f.get()));
            vk.b();
            uk.b = andIncrement;
            uk.c = TimeUnit.MILLISECONDS.toSeconds(ek.j);
            uk.d = ek.c.f476a;
        } else {
            long j = c0401l6.j;
            long a2 = sk.b.a();
            C0278g7 c0278g7 = sk.f643a.e;
            Wk wk = Wk.BACKGROUND;
            c0278g7.a(a2, wk, j);
            uk = new Uk();
            uk.f676a = a2;
            uk.d = wk;
            uk.b = 0L;
            uk.c = 0L;
        }
        f9.a(c0401l6, uk);
        return false;
    }
}
