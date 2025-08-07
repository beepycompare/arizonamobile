package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dh extends AbstractC0237eh {
    public Dh(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        ((F5) this.f831a.p).e();
        Sk sk = this.f831a.j;
        synchronized (sk) {
            Ek b = sk.b(c0402l6);
            if (b.g) {
                b.g = false;
                Vk vk = b.b;
                vk.a(Vk.i, Boolean.FALSE);
                vk.b();
            }
            if (sk.g != 1) {
                sk.b(sk.f, c0402l6);
            }
            sk.g = 1;
        }
        return true;
    }
}
