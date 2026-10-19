package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0223ek implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0611tk f972a;

    public C0223ek(InterfaceC0611tk interfaceC0611tk) {
        this.f972a = interfaceC0611tk;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        C0585sk a2 = ((Ed) this.f972a).a();
        if (a2 != null) {
            interfaceC0499pb.reportEvent(a2.f1206a, a2.b);
        }
    }
}
