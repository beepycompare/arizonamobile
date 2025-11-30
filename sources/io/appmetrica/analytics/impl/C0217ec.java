package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ec  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0217ec implements InterfaceC0569s9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0391l5 f870a;

    public C0217ec(InterfaceC0669w9 interfaceC0669w9, M6 m6, Rg rg, C0490p4 c0490p4, R4 r4, Xe xe) {
        C0192dc c0192dc = new C0192dc(m6, rg, this, c0490p4, xe);
        this.f870a = new C0391l5(interfaceC0669w9, c0192dc.a(), c0192dc.b(), r4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0569s9
    public final InterfaceC0544r9 a() {
        return this.f870a;
    }

    public final C0391l5 b() {
        return this.f870a;
    }
}
