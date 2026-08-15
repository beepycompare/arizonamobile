package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class An extends K4 {
    public final InterfaceC0492oo g;

    public An(String str, String str2, InterfaceC0492oo interfaceC0492oo, Vo vo, W2 w2) {
        super(0, str, str2, vo, w2);
        this.g = interfaceC0492oo;
    }

    @Override // io.appmetrica.analytics.impl.K4
    public final void a(Io io2) {
        String str = (String) this.g.a((String) this.f);
        io2.d.f636a = str == null ? new byte[0] : str.getBytes();
    }

    public final InterfaceC0492oo h() {
        return this.g;
    }
}
