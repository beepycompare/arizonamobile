package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Jj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f518a;

    public Jj(Throwable th) {
        this.f518a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportUnhandledException(this.f518a);
    }
}
