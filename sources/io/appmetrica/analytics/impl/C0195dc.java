package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0195dc implements InterfaceC0546r9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0368k5 f962a;

    public C0195dc(InterfaceC0646v9 interfaceC0646v9, L6 l6, Qg qg, C0467o4 c0467o4, Q4 q4, We we) {
        C0169cc c0169cc = new C0169cc(l6, qg, this, c0467o4, we);
        this.f962a = new C0368k5(interfaceC0646v9, c0169cc.a(), c0169cc.b(), q4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0546r9
    public final InterfaceC0522q9 a() {
        return this.f962a;
    }

    public final C0368k5 b() {
        return this.f962a;
    }
}
