package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0151bn extends A4 {
    public final Nn g;

    public C0151bn(String str, String str2, Nn nn, uo uoVar, R2 r2) {
        super(0, str, str2, uoVar, r2);
        this.g = nn;
    }

    @Override // io.appmetrica.analytics.impl.A4
    public final void a(C0307ho c0307ho) {
        String str = (String) this.g.a((String) this.f);
        c0307ho.d.f961a = str == null ? new byte[0] : str.getBytes();
    }

    public final Nn h() {
        return this.g;
    }
}
