package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Qj implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f740a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Qj(String str, String str2, Throwable th) {
        this.f740a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportError(this.f740a, this.b, this.c);
    }
}
