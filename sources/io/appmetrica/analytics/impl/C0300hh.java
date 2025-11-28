package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0300hh extends Wg {
    public C0300hh(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        Ik ik;
        Yk yk;
        C0544r9 c0544r9 = this.f744a.n;
        Wk wk = c0544r9.c;
        if (wk.g == 0) {
            ik = wk.d.b();
            Ik b = wk.e.b();
            if ((ik == null ? -1L : ik.d) <= (b != null ? b.d : -1L)) {
                ik = b;
            }
        } else {
            ik = wk.f;
        }
        if (ik != null) {
            yk = new Yk();
            yk.f774a = ik.d;
            long andIncrement = ik.f.getAndIncrement();
            Zk zk = ik.b;
            zk.a(Zk.g, Long.valueOf(ik.f.get()));
            zk.b();
            yk.b = andIncrement;
            yk.c = TimeUnit.MILLISECONDS.toSeconds(ik.j);
            yk.d = ik.c.f579a;
        } else {
            long j = w5.j;
            long a2 = wk.b.a();
            S6 s6 = wk.f746a.e;
            EnumC0123al enumC0123al = EnumC0123al.BACKGROUND;
            s6.a(a2, enumC0123al, j);
            yk = new Yk();
            yk.f774a = a2;
            yk.d = enumC0123al;
            yk.b = 0L;
            yk.c = 0L;
        }
        c0544r9.a(w5, yk);
        return false;
    }
}
