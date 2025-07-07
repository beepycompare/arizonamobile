package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0468nh extends AbstractC0193ch {
    public C0468nh(C0580s5 c0580s5) {
        super(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        Bk bk;
        Rk rk;
        C9 c9 = this.f785a.n;
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
            rk.f614a = bk.d;
            long andIncrement = bk.f.getAndIncrement();
            Sk sk = bk.b;
            sk.a(Sk.g, Long.valueOf(bk.f.get()));
            sk.b();
            rk.b = andIncrement;
            rk.c = TimeUnit.MILLISECONDS.toSeconds(bk.j);
            rk.d = bk.c.f413a;
        } else {
            long j = c0333i6.j;
            long a2 = pk.b.a();
            C0209d7 c0209d7 = pk.f584a.e;
            Tk tk = Tk.BACKGROUND;
            c0209d7.a(a2, tk, j);
            rk = new Rk();
            rk.f614a = a2;
            rk.d = tk;
            rk.b = 0L;
            rk.c = 0L;
        }
        c9.a(c0333i6, rk);
        return true;
    }
}
