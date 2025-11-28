package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0652vh extends Wg {
    public C0652vh(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        ((C0540r5) this.f744a.p).e();
        Wk wk = this.f744a.j;
        synchronized (wk) {
            Ik b = wk.b(w5);
            if (b.g) {
                b.g = false;
                Zk zk = b.b;
                zk.a(Zk.i, Boolean.FALSE);
                zk.b();
            }
            if (wk.g != 1) {
                wk.b(wk.f, w5);
            }
            wk.g = 1;
        }
        return true;
    }
}
