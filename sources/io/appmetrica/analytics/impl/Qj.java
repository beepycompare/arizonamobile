package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Qj implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f737a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Qj(String str, String str2, Throwable th) {
        this.f737a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportError(this.f737a, this.b, this.c);
    }
}
