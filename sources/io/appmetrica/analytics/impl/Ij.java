package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Ij implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f499a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Ij(String str, String str2, Throwable th) {
        this.f499a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportError(this.f499a, this.b, this.c);
    }
}
