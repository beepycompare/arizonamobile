package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Um extends O4 {
    public final Fn g;

    public Um(String str, String str2, Fn fn, mo moVar, W2 w2) {
        super(0, str, str2, moVar, w2);
        this.g = fn;
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(Zn zn) {
        String str = (String) this.g.a((String) this.f);
        zn.d.f774a = str == null ? new byte[0] : str.getBytes();
    }

    public final Fn h() {
        return this.g;
    }
}
