package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Nj implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f599a;

    public Nj(Throwable th) {
        this.f599a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportUnhandledException(this.f599a);
    }
}
