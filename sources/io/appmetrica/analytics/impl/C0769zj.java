package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0769zj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1169a;
    public final /* synthetic */ Throwable b;

    public C0769zj(String str, Throwable th) {
        this.f1169a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportError(this.f1169a, this.b);
    }
}
