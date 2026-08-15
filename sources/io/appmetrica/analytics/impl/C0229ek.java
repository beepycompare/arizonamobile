package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0229ek implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0617tk f969a;

    public C0229ek(InterfaceC0617tk interfaceC0617tk) {
        this.f969a = interfaceC0617tk;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        C0591sk a2 = ((Ed) this.f969a).a();
        if (a2 != null) {
            interfaceC0505pb.reportEvent(a2.f1203a, a2.b);
        }
    }
}
