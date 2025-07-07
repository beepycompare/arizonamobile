package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0357j6 extends O4 {
    public C0357j6(String str, double d) {
        super(2, str, Double.valueOf(d), new Jb(), new N4(new Zb(new H4(100))));
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(Zn zn) {
        C0174bo c0174bo = zn.d;
        c0174bo.c = ((Double) this.f).doubleValue() + c0174bo.c;
    }
}
