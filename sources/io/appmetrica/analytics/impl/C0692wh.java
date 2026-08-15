package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0692wh extends AbstractC0304hh {
    public C0692wh(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0256fl c0256fl;
        C0748yl c0748yl;
        boolean z;
        boolean z2;
        E9 e9 = this.f1019a.n;
        C0670vl c0670vl = e9.c;
        if (c0670vl.g == 0) {
            c0256fl = c0670vl.c.a();
            C0256fl a2 = c0670vl.d.a();
            if ((c0256fl == null ? -1L : c0256fl.d) <= (a2 != null ? a2.d : -1L)) {
                c0256fl = a2;
            }
        } else {
            c0256fl = c0670vl.f;
        }
        if (c0256fl != null) {
            synchronized (c0256fl) {
                z2 = c0256fl.k;
            }
            if (z2) {
                C0696wl a3 = c0670vl.f1253a.e.a(c0256fl.d, c0256fl.c.f1040a);
                long j = c0241f6.i;
                long j2 = c0241f6.j;
                c0670vl.g = 2;
                C0256fl a4 = c0670vl.e.a(new C0282gl(j, j2, a3));
                c0670vl.f = a4;
                c0670vl.a(a4.d);
                c0748yl = C0670vl.a(c0670vl.f, j);
            } else {
                c0748yl = new C0748yl();
                c0748yl.f1302a = c0256fl.d;
                long andIncrement = c0256fl.g.getAndIncrement();
                C0774zl c0774zl = c0256fl.b;
                c0774zl.a(C0774zl.g, Long.valueOf(c0256fl.g.get()));
                c0774zl.a();
                c0748yl.b = andIncrement;
                long j3 = c0241f6.j;
                long j4 = c0241f6.i;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long seconds = timeUnit.toSeconds(j3 - c0256fl.f);
                C0774zl c0774zl2 = c0256fl.b;
                long j5 = j4 - c0256fl.e;
                c0256fl.j = j5;
                c0774zl2.a(C0774zl.e, Long.valueOf(j5));
                c0774zl2.a();
                c0748yl.c = Math.max(seconds, timeUnit.toSeconds(c0256fl.j));
                c0748yl.d = c0256fl.c.f1040a;
            }
        } else {
            c0748yl = null;
        }
        if (c0748yl != null) {
            e9.a(c0241f6, c0748yl);
            z = true;
        } else {
            z = false;
        }
        return !z;
    }
}
