package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f728a;
    public final /* synthetic */ byte[] b;

    public Xj(String str, byte[] bArr) {
        this.f728a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.setSessionExtra(this.f728a, this.b);
    }
}
