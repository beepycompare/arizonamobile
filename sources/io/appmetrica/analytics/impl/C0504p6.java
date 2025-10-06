package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0504p6 extends R4 {
    public C0504p6(String str, double d) {
        super(2, str, Double.valueOf(d), new Qb(), new Q4(new C0277gc(new K4(100))));
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final void a(C0418lo c0418lo) {
        C0470no c0470no = c0418lo.d;
        c0470no.c = ((Double) this.f).doubleValue() + c0470no.c;
    }
}
