package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class R5 extends AbstractC0613u4 {
    public R5(String str, double d) {
        super(2, str, Double.valueOf(d), new C0545rb(), new C0588t4(new Hb(new C0439n4(100))));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0613u4
    public final void a(C0280go c0280go) {
        C0331io c0331io = c0280go.d;
        c0331io.c = ((Double) this.f).doubleValue() + c0331io.c;
    }
}
