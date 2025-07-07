package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0687wc implements J9 {

    /* renamed from: a  reason: collision with root package name */
    public final D5 f1104a;

    public C0687wc(N9 n9, C0209d7 c0209d7, C0167bh c0167bh, J4 j4, C0406l5 c0406l5, Cif cif) {
        C0662vc c0662vc = new C0662vc(c0209d7, c0167bh, this, j4, cif);
        this.f1104a = new D5(n9, c0662vc.a(), c0662vc.b(), c0406l5);
    }

    @Override // io.appmetrica.analytics.impl.J9
    public final I9 a() {
        return this.f1104a;
    }

    public final D5 b() {
        return this.f1104a;
    }
}
