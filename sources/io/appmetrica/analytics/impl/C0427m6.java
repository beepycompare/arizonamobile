package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0427m6 extends O4 {
    public C0427m6(String str, double d) {
        super(2, str, Double.valueOf(d), new Lb(), new N4(new C0155bc(new H4(100))));
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(C0193co c0193co) {
        C0244eo c0244eo = c0193co.d;
        c0244eo.c = ((Double) this.f).doubleValue() + c0244eo.c;
    }
}
