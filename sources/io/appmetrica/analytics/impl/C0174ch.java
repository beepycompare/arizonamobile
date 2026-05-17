package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0174ch extends Rg {
    public C0174ch(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        Dk dk;
        Tk tk;
        C0372k9 c0372k9 = this.f772a.n;
        Rk rk = c0372k9.c;
        if (rk.g == 0) {
            dk = rk.d.b();
            Dk b = rk.e.b();
            if ((dk == null ? -1L : dk.d) <= (b != null ? b.d : -1L)) {
                dk = b;
            }
        } else {
            dk = rk.f;
        }
        if (dk != null) {
            tk = new Tk();
            tk.f807a = dk.d;
            long andIncrement = dk.f.getAndIncrement();
            Uk uk = dk.b;
            uk.a(Uk.g, Long.valueOf(dk.f.get()));
            uk.b();
            tk.b = andIncrement;
            tk.c = TimeUnit.MILLISECONDS.toSeconds(dk.j);
            tk.d = dk.c.f605a;
        } else {
            long j = p5.j;
            long a2 = rk.b.a();
            L6 l6 = rk.f774a.e;
            Vk vk = Vk.BACKGROUND;
            l6.a(a2, vk, j);
            tk = new Tk();
            tk.f807a = a2;
            tk.d = vk;
            tk.b = 0L;
            tk.c = 0L;
        }
        c0372k9.a(p5, tk);
        return false;
    }
}
