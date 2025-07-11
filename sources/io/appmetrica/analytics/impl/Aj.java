package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Aj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f339a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Aj(String str, String str2, Throwable th) {
        this.f339a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportError(this.f339a, this.b, this.c);
    }
}
