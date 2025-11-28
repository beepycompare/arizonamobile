package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0372kc implements InterfaceC0719y9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0540r5 f972a;

    public C0372kc(C9 c9, S6 s6, Vg vg, C0639v4 c0639v4, X4 x4, C0143bf c0143bf) {
        C0346jc c0346jc = new C0346jc(s6, vg, this, c0639v4, c0143bf);
        this.f972a = new C0540r5(c9, c0346jc.a(), c0346jc.b(), x4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0719y9
    public final InterfaceC0694x9 a() {
        return this.f972a;
    }

    public final C0540r5 b() {
        return this.f972a;
    }
}
