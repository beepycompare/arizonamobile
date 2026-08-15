package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Rj implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f752a;

    public Rj(Throwable th) {
        this.f752a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportUnhandledException(this.f752a);
    }
}
