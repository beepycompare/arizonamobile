package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288gn extends R4 {
    public final Rn g;

    public C0288gn(String str, String str2, Rn rn, yo yoVar, Z2 z2) {
        super(0, str, str2, yoVar, z2);
        this.g = rn;
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final void a(C0418lo c0418lo) {
        String str = (String) this.g.a((String) this.f);
        c0418lo.d.f1011a = str == null ? new byte[0] : str.getBytes();
    }

    public final Rn h() {
        return this.g;
    }
}
