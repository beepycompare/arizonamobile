package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Lj implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f558a;
    public final /* synthetic */ Throwable b;

    public Lj(String str, Throwable th) {
        this.f558a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportError(this.f558a, this.b);
    }
}
