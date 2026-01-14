package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0196dc implements InterfaceC0547r9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0369k5 f958a;

    public C0196dc(InterfaceC0647v9 interfaceC0647v9, L6 l6, Qg qg, C0468o4 c0468o4, Q4 q4, We we) {
        C0170cc c0170cc = new C0170cc(l6, qg, this, c0468o4, we);
        this.f958a = new C0369k5(interfaceC0647v9, c0170cc.a(), c0170cc.b(), q4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0547r9
    public final InterfaceC0523q9 a() {
        return this.f958a;
    }

    public final C0369k5 b() {
        return this.f958a;
    }
}
