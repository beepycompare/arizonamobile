package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mh extends AbstractC0462nh {
    public Mh(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        ((I5) this.f1005a.p).e();
        C0156bl c0156bl = this.f1005a.j;
        synchronized (c0156bl) {
            Nk b = c0156bl.b(c0477o6);
            if (b.g) {
                b.g = false;
                C0233el c0233el = b.b;
                c0233el.a(C0233el.i, Boolean.FALSE);
                c0233el.b();
            }
            if (c0156bl.g != 1) {
                c0156bl.b(c0156bl.f, c0477o6);
            }
            c0156bl.g = 1;
        }
        return true;
    }
}
