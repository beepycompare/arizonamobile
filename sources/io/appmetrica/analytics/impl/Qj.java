package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Qj implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f735a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Qj(String str, String str2, Throwable th) {
        this.f735a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportError(this.f735a, this.b, this.c);
    }
}
