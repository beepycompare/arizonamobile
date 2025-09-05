package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0503p6 extends R4 {
    public C0503p6(String str, double d) {
        super(2, str, Double.valueOf(d), new Qb(), new Q4(new C0276gc(new K4(100))));
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final void a(C0417lo c0417lo) {
        C0469no c0469no = c0417lo.d;
        c0469no.c = ((Double) this.f).doubleValue() + c0469no.c;
    }
}
