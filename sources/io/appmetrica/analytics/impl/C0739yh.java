package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0739yh extends AbstractC0463nh {
    public C0739yh(C0652v5 c0652v5) {
        super(c0652v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        Nk nk;
        C0209dl c0209dl;
        K9 k9 = this.f1006a.n;
        C0157bl c0157bl = k9.c;
        if (c0157bl.g == 0) {
            nk = c0157bl.d.b();
            Nk b = c0157bl.e.b();
            if ((nk == null ? -1L : nk.d) <= (b != null ? b.d : -1L)) {
                nk = b;
            }
        } else {
            nk = c0157bl.f;
        }
        if (nk != null) {
            c0209dl = new C0209dl();
            c0209dl.f850a = nk.d;
            long andIncrement = nk.f.getAndIncrement();
            C0234el c0234el = nk.b;
            c0234el.a(C0234el.g, Long.valueOf(nk.f.get()));
            c0234el.b();
            c0209dl.b = andIncrement;
            c0209dl.c = TimeUnit.MILLISECONDS.toSeconds(nk.j);
            c0209dl.d = nk.c.f644a;
        } else {
            long j = c0478o6.j;
            long a2 = c0157bl.b.a();
            C0375k7 c0375k7 = c0157bl.f815a.e;
            EnumC0260fl enumC0260fl = EnumC0260fl.BACKGROUND;
            c0375k7.a(a2, enumC0260fl, j);
            c0209dl = new C0209dl();
            c0209dl.f850a = a2;
            c0209dl.d = enumC0260fl;
            c0209dl.b = 0L;
            c0209dl.c = 0L;
        }
        k9.a(c0478o6, c0209dl);
        return false;
    }
}
