package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Pj implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f721a;
    public final /* synthetic */ Throwable b;

    public Pj(String str, Throwable th) {
        this.f721a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportError(this.f721a, this.b);
    }
}
