package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Bh extends AbstractC0193ch {
    public Bh(C0580s5 c0580s5) {
        super(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        ((D5) this.f785a.p).e();
        Pk pk = this.f785a.j;
        synchronized (pk) {
            Bk b = pk.b(c0333i6);
            if (b.g) {
                b.g = false;
                Sk sk = b.b;
                sk.a(Sk.i, Boolean.FALSE);
                sk.b();
            }
            if (pk.g != 1) {
                pk.b(pk.f, c0333i6);
            }
            pk.g = 1;
        }
        return false;
    }
}
