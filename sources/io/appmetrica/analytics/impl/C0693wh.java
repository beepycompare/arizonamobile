package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0693wh extends AbstractC0305hh {
    public C0693wh(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0257fl c0257fl;
        C0749yl c0749yl;
        boolean z;
        boolean z2;
        E9 e9 = this.f1019a.n;
        C0671vl c0671vl = e9.c;
        if (c0671vl.g == 0) {
            c0257fl = c0671vl.c.a();
            C0257fl a2 = c0671vl.d.a();
            if ((c0257fl == null ? -1L : c0257fl.d) <= (a2 != null ? a2.d : -1L)) {
                c0257fl = a2;
            }
        } else {
            c0257fl = c0671vl.f;
        }
        if (c0257fl != null) {
            synchronized (c0257fl) {
                z2 = c0257fl.k;
            }
            if (z2) {
                C0697wl a3 = c0671vl.f1253a.e.a(c0257fl.d, c0257fl.c.f1040a);
                long j = c0242f6.i;
                long j2 = c0242f6.j;
                c0671vl.g = 2;
                C0257fl a4 = c0671vl.e.a(new C0283gl(j, j2, a3));
                c0671vl.f = a4;
                c0671vl.a(a4.d);
                c0749yl = C0671vl.a(c0671vl.f, j);
            } else {
                c0749yl = new C0749yl();
                c0749yl.f1302a = c0257fl.d;
                long andIncrement = c0257fl.g.getAndIncrement();
                C0775zl c0775zl = c0257fl.b;
                c0775zl.a(C0775zl.g, Long.valueOf(c0257fl.g.get()));
                c0775zl.a();
                c0749yl.b = andIncrement;
                long j3 = c0242f6.j;
                long j4 = c0242f6.i;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long seconds = timeUnit.toSeconds(j3 - c0257fl.f);
                C0775zl c0775zl2 = c0257fl.b;
                long j5 = j4 - c0257fl.e;
                c0257fl.j = j5;
                c0775zl2.a(C0775zl.e, Long.valueOf(j5));
                c0775zl2.a();
                c0749yl.c = Math.max(seconds, timeUnit.toSeconds(c0257fl.j));
                c0749yl.d = c0257fl.c.f1040a;
            }
        } else {
            c0749yl = null;
        }
        if (c0749yl != null) {
            e9.a(c0242f6, c0749yl);
            z = true;
        } else {
            z = false;
        }
        return !z;
    }
}
