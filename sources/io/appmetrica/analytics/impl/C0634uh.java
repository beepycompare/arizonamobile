package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.uh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0634uh extends AbstractC0358jh {
    public C0634uh(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        Jk jk;
        Zk zk;
        H9 h9 = this.f925a.n;
        Xk xk = h9.c;
        if (xk.g == 0) {
            jk = xk.d.b();
            Jk b = xk.e.b();
            if ((jk == null ? -1L : jk.d) <= (b != null ? b.d : -1L)) {
                jk = b;
            }
        } else {
            jk = xk.f;
        }
        if (jk != null) {
            zk = new Zk();
            zk.f763a = jk.d;
            long andIncrement = jk.f.getAndIncrement();
            C0130al c0130al = jk.b;
            c0130al.a(C0130al.g, Long.valueOf(jk.f.get()));
            c0130al.b();
            zk.b = andIncrement;
            zk.c = TimeUnit.MILLISECONDS.toSeconds(jk.j);
            zk.d = jk.c.f564a;
        } else {
            long j = c0399l6.j;
            long a2 = xk.b.a();
            C0297h7 c0297h7 = xk.f729a.e;
            EnumC0156bl enumC0156bl = EnumC0156bl.BACKGROUND;
            c0297h7.a(a2, enumC0156bl, j);
            zk = new Zk();
            zk.f763a = a2;
            zk.d = enumC0156bl;
            zk.b = 0L;
            zk.c = 0L;
        }
        h9.a(c0399l6, zk);
        return false;
    }
}
