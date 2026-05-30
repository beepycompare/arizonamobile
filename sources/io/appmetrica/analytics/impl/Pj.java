package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Pj implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f719a;
    public final /* synthetic */ Throwable b;

    public Pj(String str, Throwable th) {
        this.f719a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportError(this.f719a, this.b);
    }
}
