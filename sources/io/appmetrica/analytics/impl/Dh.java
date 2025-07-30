package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dh extends AbstractC0236eh {
    public Dh(C0574s5 c0574s5) {
        super(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        ((F5) this.f832a.p).e();
        Sk sk = this.f832a.j;
        synchronized (sk) {
            Ek b = sk.b(c0401l6);
            if (b.g) {
                b.g = false;
                Vk vk = b.b;
                vk.a(Vk.i, Boolean.FALSE);
                vk.b();
            }
            if (sk.g != 1) {
                sk.b(sk.f, c0401l6);
            }
            sk.g = 1;
        }
        return true;
    }
}
