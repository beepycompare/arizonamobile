package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0230ek implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0618tk f966a;

    public C0230ek(InterfaceC0618tk interfaceC0618tk) {
        this.f966a = interfaceC0618tk;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        C0592sk a2 = ((Ed) this.f966a).a();
        if (a2 != null) {
            interfaceC0506pb.reportEvent(a2.f1200a, a2.b);
        }
    }
}
