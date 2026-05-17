package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ym extends AbstractC0591t4 {
    public final Ln g;

    public Ym(String str, String str2, Ln ln, so soVar, J2 j2) {
        super(0, str, str2, soVar, j2);
        this.g = ln;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0591t4
    public final void a(C0258fo c0258fo) {
        String str = (String) this.g.a((String) this.f);
        c0258fo.d.f1039a = str == null ? new byte[0] : str.getBytes();
    }

    public final Ln h() {
        return this.g;
    }
}
