package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0738yh extends AbstractC0462nh {
    public C0738yh(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        Nk nk;
        C0208dl c0208dl;
        K9 k9 = this.f1006a.n;
        C0156bl c0156bl = k9.c;
        if (c0156bl.g == 0) {
            nk = c0156bl.d.b();
            Nk b = c0156bl.e.b();
            if ((nk == null ? -1L : nk.d) <= (b != null ? b.d : -1L)) {
                nk = b;
            }
        } else {
            nk = c0156bl.f;
        }
        if (nk != null) {
            c0208dl = new C0208dl();
            c0208dl.f850a = nk.d;
            long andIncrement = nk.f.getAndIncrement();
            C0233el c0233el = nk.b;
            c0233el.a(C0233el.g, Long.valueOf(nk.f.get()));
            c0233el.b();
            c0208dl.b = andIncrement;
            c0208dl.c = TimeUnit.MILLISECONDS.toSeconds(nk.j);
            c0208dl.d = nk.c.f644a;
        } else {
            long j = c0477o6.j;
            long a2 = c0156bl.b.a();
            C0374k7 c0374k7 = c0156bl.f815a.e;
            EnumC0259fl enumC0259fl = EnumC0259fl.BACKGROUND;
            c0374k7.a(a2, enumC0259fl, j);
            c0208dl = new C0208dl();
            c0208dl.f850a = a2;
            c0208dl.d = enumC0259fl;
            c0208dl.b = 0L;
            c0208dl.c = 0L;
        }
        k9.a(c0477o6, c0208dl);
        return false;
    }
}
