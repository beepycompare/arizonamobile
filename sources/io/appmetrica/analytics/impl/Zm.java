package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Zm extends AbstractC0613u4 {
    public final Mn g;

    public Zm(String str, String str2, Mn mn, to toVar, K2 k2) {
        super(0, str, str2, toVar, k2);
        this.g = mn;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0613u4
    public final void a(C0280go c0280go) {
        String str = (String) this.g.a((String) this.f);
        c0280go.d.f1043a = str == null ? new byte[0] : str.getBytes();
    }

    public final Mn h() {
        return this.g;
    }
}
