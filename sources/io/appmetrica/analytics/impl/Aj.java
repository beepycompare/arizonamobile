package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Aj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f338a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Aj(String str, String str2, Throwable th) {
        this.f338a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportError(this.f338a, this.b, this.c);
    }
}
