package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mj implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f580a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Mj(String str, String str2, Throwable th) {
        this.f580a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportError(this.f580a, this.b, this.c);
    }
}
