package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh extends AbstractC0305hh {
    public Kh(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0257fl c0257fl;
        ((A5) this.f1019a.p).e();
        C0671vl c0671vl = this.f1019a.j;
        synchronized (c0671vl) {
            if (c0671vl.g == 0) {
                c0257fl = c0671vl.c.a();
                C0257fl a2 = c0671vl.d.a();
                long j = -1;
                long j2 = c0257fl == null ? -1L : c0257fl.d;
                if (a2 != null) {
                    j = a2.d;
                }
                if (j2 <= j) {
                    c0257fl = a2;
                }
            } else {
                c0257fl = c0671vl.f;
            }
            if (c0257fl != null) {
                c0257fl.b();
                if (c0257fl.h) {
                    c0257fl.h = false;
                    C0775zl c0775zl = c0257fl.b;
                    c0775zl.a(C0775zl.j, Boolean.FALSE);
                    c0775zl.a();
                }
                c0671vl.g = 0;
            }
        }
        return true;
    }
}
