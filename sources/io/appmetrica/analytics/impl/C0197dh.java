package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.dh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0197dh extends Sg {
    public C0197dh(Y4 y4) {
        super(y4);
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Ek ek;
        Uk uk;
        C0395l9 c0395l9 = this.f679a.n;
        Sk sk = c0395l9.c;
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
            uk.f714a = ek.d;
            long andIncrement = ek.f.getAndIncrement();
            Vk vk = ek.b;
            vk.a(Vk.g, Long.valueOf(ek.f.get()));
            vk.b();
            uk.b = andIncrement;
            uk.c = TimeUnit.MILLISECONDS.toSeconds(ek.j);
            uk.d = ek.c.f511a;
        } else {
            long j = q5.j;
            long a2 = sk.b.a();
            M6 m6 = sk.f681a.e;
            Wk wk = Wk.BACKGROUND;
            m6.a(a2, wk, j);
            uk = new Uk();
            uk.f714a = a2;
            uk.d = wk;
            uk.b = 0L;
            uk.c = 0L;
        }
        c0395l9.a(q5, uk);
        return false;
    }
}
