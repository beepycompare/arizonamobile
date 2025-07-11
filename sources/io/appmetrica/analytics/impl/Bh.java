package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Bh extends AbstractC0185ch {
    public Bh(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        ((D5) this.f786a.p).e();
        Pk pk = this.f786a.j;
        synchronized (pk) {
            Bk b = pk.b(c0325i6);
            if (b.g) {
                b.g = false;
                Sk sk = b.b;
                sk.a(Sk.i, Boolean.FALSE);
                sk.b();
            }
            if (pk.g != 1) {
                pk.b(pk.f, c0325i6);
            }
            pk.g = 1;
        }
        return false;
    }
}
