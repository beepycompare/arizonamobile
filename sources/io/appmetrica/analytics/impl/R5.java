package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R5 extends AbstractC0614u4 {
    public R5(String str, double d) {
        super(2, str, Double.valueOf(d), new C0546rb(), new C0589t4(new Hb(new C0440n4(100))));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0614u4
    public final void a(C0281go c0281go) {
        C0332io c0332io = c0281go.d;
        c0332io.c = ((Double) this.f).doubleValue() + c0332io.c;
    }
}
