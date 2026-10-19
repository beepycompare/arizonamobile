package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh extends AbstractC0298hh {
    public Kh(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0250fl c0250fl;
        ((A5) this.f1022a.p).e();
        C0664vl c0664vl = this.f1022a.j;
        synchronized (c0664vl) {
            if (c0664vl.g == 0) {
                c0250fl = c0664vl.c.a();
                C0250fl a2 = c0664vl.d.a();
                long j = -1;
                long j2 = c0250fl == null ? -1L : c0250fl.d;
                if (a2 != null) {
                    j = a2.d;
                }
                if (j2 <= j) {
                    c0250fl = a2;
                }
            } else {
                c0250fl = c0664vl.f;
            }
            if (c0250fl != null) {
                c0250fl.b();
                if (c0250fl.h) {
                    c0250fl.h = false;
                    C0768zl c0768zl = c0250fl.b;
                    c0768zl.a(C0768zl.j, Boolean.FALSE);
                    c0768zl.a();
                }
                c0664vl.g = 0;
            }
        }
        return true;
    }
}
