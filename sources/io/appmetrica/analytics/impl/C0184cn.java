package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0184cn extends O4 {
    public final Nn g;

    public C0184cn(String str, String str2, Nn nn, uo uoVar, W2 w2) {
        super(0, str, str2, uoVar, w2);
        this.g = nn;
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(C0314ho c0314ho) {
        String str = (String) this.g.a((String) this.f);
        c0314ho.d.f930a = str == null ? new byte[0] : str.getBytes();
    }

    public final Nn h() {
        return this.g;
    }
}
