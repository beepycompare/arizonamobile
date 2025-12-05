package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ec  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0216ec implements InterfaceC0568s9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0390l5 f953a;

    public C0216ec(InterfaceC0668w9 interfaceC0668w9, M6 m6, Rg rg, C0489p4 c0489p4, R4 r4, Xe xe) {
        C0191dc c0191dc = new C0191dc(m6, rg, this, c0489p4, xe);
        this.f953a = new C0390l5(interfaceC0668w9, c0191dc.a(), c0191dc.b(), r4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0568s9
    public final InterfaceC0543r9 a() {
        return this.f953a;
    }

    public final C0390l5 b() {
        return this.f953a;
    }
}
