package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0228ek implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0616tk f969a;

    public C0228ek(InterfaceC0616tk interfaceC0616tk) {
        this.f969a = interfaceC0616tk;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        C0590sk a2 = ((Ed) this.f969a).a();
        if (a2 != null) {
            interfaceC0504pb.reportEvent(a2.f1203a, a2.b);
        }
    }
}
