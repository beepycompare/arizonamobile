package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0686wh extends AbstractC0298hh {
    public C0686wh(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0250fl c0250fl;
        C0742yl c0742yl;
        boolean z;
        boolean z2;
        E9 e9 = this.f1022a.n;
        C0664vl c0664vl = e9.c;
        if (c0664vl.g == 0) {
            c0250fl = c0664vl.c.a();
            C0250fl a2 = c0664vl.d.a();
            if ((c0250fl == null ? -1L : c0250fl.d) <= (a2 != null ? a2.d : -1L)) {
                c0250fl = a2;
            }
        } else {
            c0250fl = c0664vl.f;
        }
        if (c0250fl != null) {
            synchronized (c0250fl) {
                z2 = c0250fl.k;
            }
            if (z2) {
                C0690wl a3 = c0664vl.f1256a.e.a(c0250fl.d, c0250fl.c.f1043a);
                long j = c0235f6.i;
                long j2 = c0235f6.j;
                c0664vl.g = 2;
                C0250fl a4 = c0664vl.e.a(new C0276gl(j, j2, a3));
                c0664vl.f = a4;
                c0664vl.a(a4.d);
                c0742yl = C0664vl.a(c0664vl.f, j);
            } else {
                c0742yl = new C0742yl();
                c0742yl.f1305a = c0250fl.d;
                long andIncrement = c0250fl.g.getAndIncrement();
                C0768zl c0768zl = c0250fl.b;
                c0768zl.a(C0768zl.g, Long.valueOf(c0250fl.g.get()));
                c0768zl.a();
                c0742yl.b = andIncrement;
                long j3 = c0235f6.j;
                long j4 = c0235f6.i;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long seconds = timeUnit.toSeconds(j3 - c0250fl.f);
                C0768zl c0768zl2 = c0250fl.b;
                long j5 = j4 - c0250fl.e;
                c0250fl.j = j5;
                c0768zl2.a(C0768zl.e, Long.valueOf(j5));
                c0768zl2.a();
                c0742yl.c = Math.max(seconds, timeUnit.toSeconds(c0250fl.j));
                c0742yl.d = c0250fl.c.f1043a;
            }
        } else {
            c0742yl = null;
        }
        if (c0742yl != null) {
            e9.a(c0235f6, c0742yl);
            z = true;
        } else {
            z = false;
        }
        return !z;
    }
}
