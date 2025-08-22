package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Hj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f480a;
    public final /* synthetic */ Throwable b;

    public Hj(String str, Throwable th) {
        this.f480a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportError(this.f480a, this.b);
    }
}
