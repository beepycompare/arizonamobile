package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mh extends AbstractC0463nh {
    public Mh(C0652v5 c0652v5) {
        super(c0652v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        ((I5) this.f1006a.p).e();
        C0157bl c0157bl = this.f1006a.j;
        synchronized (c0157bl) {
            Nk b = c0157bl.b(c0478o6);
            if (b.g) {
                b.g = false;
                C0234el c0234el = b.b;
                c0234el.a(C0234el.i, Boolean.FALSE);
                c0234el.b();
            }
            if (c0157bl.g != 1) {
                c0157bl.b(c0157bl.f, c0478o6);
            }
            c0157bl.g = 1;
        }
        return true;
    }
}
