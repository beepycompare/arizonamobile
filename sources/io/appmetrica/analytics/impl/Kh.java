package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh extends AbstractC0303hh {
    public Kh(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0255fl c0255fl;
        ((A5) this.f1019a.p).e();
        C0669vl c0669vl = this.f1019a.j;
        synchronized (c0669vl) {
            if (c0669vl.g == 0) {
                c0255fl = c0669vl.c.a();
                C0255fl a2 = c0669vl.d.a();
                long j = -1;
                long j2 = c0255fl == null ? -1L : c0255fl.d;
                if (a2 != null) {
                    j = a2.d;
                }
                if (j2 <= j) {
                    c0255fl = a2;
                }
            } else {
                c0255fl = c0669vl.f;
            }
            if (c0255fl != null) {
                c0255fl.b();
                if (c0255fl.h) {
                    c0255fl.h = false;
                    C0773zl c0773zl = c0255fl.b;
                    c0773zl.a(C0773zl.j, Boolean.FALSE);
                    c0773zl.a();
                }
                c0669vl.g = 0;
            }
        }
        return true;
    }
}
