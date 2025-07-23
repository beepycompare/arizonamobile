package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0426m6 extends O4 {
    public C0426m6(String str, double d) {
        super(2, str, Double.valueOf(d), new Lb(), new N4(new C0154bc(new H4(100))));
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(C0192co c0192co) {
        C0243eo c0243eo = c0192co.d;
        c0243eo.c = ((Double) this.f).doubleValue() + c0243eo.c;
    }
}
