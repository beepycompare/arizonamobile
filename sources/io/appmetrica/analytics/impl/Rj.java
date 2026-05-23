package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Rj implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f749a;

    public Rj(Throwable th) {
        this.f749a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportUnhandledException(this.f749a);
    }
}
