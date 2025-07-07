package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Pj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f583a;
    public final /* synthetic */ byte[] b;

    public Pj(String str, byte[] bArr) {
        this.f583a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.setSessionExtra(this.f583a, this.b);
    }
}
