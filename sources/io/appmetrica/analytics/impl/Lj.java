package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Lj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f563a;
    public final /* synthetic */ Throwable b;

    public Lj(String str, Throwable th) {
        this.f563a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportError(this.f563a, this.b);
    }
}
