package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0268g6 extends K4 {
    public C0268g6(String str, double d) {
        super(2, str, Double.valueOf(d), new Sb(), new J4(new C0326ic(new D4(100))));
    }

    @Override // io.appmetrica.analytics.impl.K4
    public final void a(Io io2) {
        Ko ko = io2.d;
        ko.c = ((Double) this.f).doubleValue() + ko.c;
    }
}
