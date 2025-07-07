package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Bj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f358a;

    public Bj(Throwable th) {
        this.f358a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportUnhandledException(this.f358a);
    }
}
