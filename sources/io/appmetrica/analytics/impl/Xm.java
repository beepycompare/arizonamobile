package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xm extends O4 {
    public final In g;

    public Xm(String str, String str2, In in, po poVar, W2 w2) {
        super(0, str, str2, poVar, w2);
        this.g = in;
    }

    @Override // io.appmetrica.analytics.impl.O4
    public final void a(C0193co c0193co) {
        String str = (String) this.g.a((String) this.f);
        c0193co.d.f836a = str == null ? new byte[0] : str.getBytes();
    }

    public final In h() {
        return this.g;
    }
}
