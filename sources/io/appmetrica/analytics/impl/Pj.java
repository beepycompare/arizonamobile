package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Pj implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f724a;
    public final /* synthetic */ Throwable b;

    public Pj(String str, Throwable th) {
        this.f724a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportError(this.f724a, this.b);
    }
}
