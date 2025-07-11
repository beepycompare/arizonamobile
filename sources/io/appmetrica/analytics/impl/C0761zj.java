package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0761zj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1170a;
    public final /* synthetic */ Throwable b;

    public C0761zj(String str, Throwable th) {
        this.f1170a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportError(this.f1170a, this.b);
    }
}
