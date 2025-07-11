package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0460nh extends AbstractC0185ch {
    public C0460nh(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        Bk bk;
        Rk rk;
        C9 c9 = this.f786a.n;
        Pk pk = c9.c;
        if (pk.g == 0) {
            bk = pk.d.b();
            Bk b = pk.e.b();
            if ((bk == null ? -1L : bk.d) <= (b != null ? b.d : -1L)) {
                bk = b;
            }
        } else {
            bk = pk.f;
        }
        if (bk != null) {
            rk = new Rk();
            rk.f615a = bk.d;
            long andIncrement = bk.f.getAndIncrement();
            Sk sk = bk.b;
            sk.a(Sk.g, Long.valueOf(bk.f.get()));
            sk.b();
            rk.b = andIncrement;
            rk.c = TimeUnit.MILLISECONDS.toSeconds(bk.j);
            rk.d = bk.c.f414a;
        } else {
            long j = c0325i6.j;
            long a2 = pk.b.a();
            C0201d7 c0201d7 = pk.f585a.e;
            Tk tk = Tk.BACKGROUND;
            c0201d7.a(a2, tk, j);
            rk = new Rk();
            rk.f615a = a2;
            rk.d = tk;
            rk.b = 0L;
            rk.c = 0L;
        }
        c9.a(c0325i6, rk);
        return true;
    }
}
