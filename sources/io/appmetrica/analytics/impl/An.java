package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class An extends K4 {
    public final InterfaceC0493oo g;

    public An(String str, String str2, InterfaceC0493oo interfaceC0493oo, Vo vo, W2 w2) {
        super(0, str, str2, vo, w2);
        this.g = interfaceC0493oo;
    }

    @Override // io.appmetrica.analytics.impl.K4
    public final void a(Io io2) {
        String str = (String) this.g.a((String) this.f);
        io2.d.f634a = str == null ? new byte[0] : str.getBytes();
    }

    public final InterfaceC0493oo h() {
        return this.g;
    }
}
