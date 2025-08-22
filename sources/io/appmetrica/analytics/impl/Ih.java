package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Ih extends AbstractC0358jh {
    public Ih(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        ((F5) this.f925a.p).e();
        Xk xk = this.f925a.j;
        synchronized (xk) {
            Jk b = xk.b(c0399l6);
            if (b.g) {
                b.g = false;
                C0130al c0130al = b.b;
                c0130al.a(C0130al.i, Boolean.FALSE);
                c0130al.b();
            }
            if (xk.g != 1) {
                xk.b(xk.f, c0399l6);
            }
            xk.g = 1;
        }
        return true;
    }
}
