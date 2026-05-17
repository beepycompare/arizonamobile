package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0530qh extends Rg {
    public C0530qh(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        ((C0368k5) this.f772a.p).e();
        Rk rk = this.f772a.j;
        synchronized (rk) {
            Dk b = rk.b(p5);
            if (b.g) {
                b.g = false;
                Uk uk = b.b;
                uk.a(Uk.i, Boolean.FALSE);
                uk.b();
            }
            if (rk.g != 1) {
                rk.b(rk.f, p5);
            }
            rk.g = 1;
        }
        return true;
    }
}
