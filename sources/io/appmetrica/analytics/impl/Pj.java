package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Pj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f584a;
    public final /* synthetic */ byte[] b;

    public Pj(String str, byte[] bArr) {
        this.f584a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.setSessionExtra(this.f584a, this.b);
    }
}
