package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0691wh extends AbstractC0303hh {
    public C0691wh(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0255fl c0255fl;
        C0747yl c0747yl;
        boolean z;
        boolean z2;
        E9 e9 = this.f1019a.n;
        C0669vl c0669vl = e9.c;
        if (c0669vl.g == 0) {
            c0255fl = c0669vl.c.a();
            C0255fl a2 = c0669vl.d.a();
            if ((c0255fl == null ? -1L : c0255fl.d) <= (a2 != null ? a2.d : -1L)) {
                c0255fl = a2;
            }
        } else {
            c0255fl = c0669vl.f;
        }
        if (c0255fl != null) {
            synchronized (c0255fl) {
                z2 = c0255fl.k;
            }
            if (z2) {
                C0695wl a3 = c0669vl.f1253a.e.a(c0255fl.d, c0255fl.c.f1040a);
                long j = c0240f6.i;
                long j2 = c0240f6.j;
                c0669vl.g = 2;
                C0255fl a4 = c0669vl.e.a(new C0281gl(j, j2, a3));
                c0669vl.f = a4;
                c0669vl.a(a4.d);
                c0747yl = C0669vl.a(c0669vl.f, j);
            } else {
                c0747yl = new C0747yl();
                c0747yl.f1302a = c0255fl.d;
                long andIncrement = c0255fl.g.getAndIncrement();
                C0773zl c0773zl = c0255fl.b;
                c0773zl.a(C0773zl.g, Long.valueOf(c0255fl.g.get()));
                c0773zl.a();
                c0747yl.b = andIncrement;
                long j3 = c0240f6.j;
                long j4 = c0240f6.i;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long seconds = timeUnit.toSeconds(j3 - c0255fl.f);
                C0773zl c0773zl2 = c0255fl.b;
                long j5 = j4 - c0255fl.e;
                c0255fl.j = j5;
                c0773zl2.a(C0773zl.e, Long.valueOf(j5));
                c0773zl2.a();
                c0747yl.c = Math.max(seconds, timeUnit.toSeconds(c0255fl.j));
                c0747yl.d = c0255fl.c.f1040a;
            }
        } else {
            c0747yl = null;
        }
        if (c0747yl != null) {
            e9.a(c0240f6, c0747yl);
            z = true;
        } else {
            z = false;
        }
        return !z;
    }
}
