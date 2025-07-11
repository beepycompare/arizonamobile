package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Bj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f359a;

    public Bj(Throwable th) {
        this.f359a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportUnhandledException(this.f359a);
    }
}
