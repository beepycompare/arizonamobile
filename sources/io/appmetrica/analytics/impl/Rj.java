package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Rj implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f752a;

    public Rj(Throwable th) {
        this.f752a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportUnhandledException(this.f752a);
    }
}
