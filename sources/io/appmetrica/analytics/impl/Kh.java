package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh extends AbstractC0304hh {
    public Kh(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0256fl c0256fl;
        ((A5) this.f1019a.p).e();
        C0670vl c0670vl = this.f1019a.j;
        synchronized (c0670vl) {
            if (c0670vl.g == 0) {
                c0256fl = c0670vl.c.a();
                C0256fl a2 = c0670vl.d.a();
                long j = -1;
                long j2 = c0256fl == null ? -1L : c0256fl.d;
                if (a2 != null) {
                    j = a2.d;
                }
                if (j2 <= j) {
                    c0256fl = a2;
                }
            } else {
                c0256fl = c0670vl.f;
            }
            if (c0256fl != null) {
                c0256fl.b();
                if (c0256fl.h) {
                    c0256fl.h = false;
                    C0774zl c0774zl = c0256fl.b;
                    c0774zl.a(C0774zl.j, Boolean.FALSE);
                    c0774zl.a();
                }
                c0670vl.g = 0;
            }
        }
        return true;
    }
}
