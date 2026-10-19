package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0275gk implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1005a;
    public final /* synthetic */ byte[] b;

    public C0275gk(String str, byte[] bArr) {
        this.f1005a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.setSessionExtra(this.f1005a, this.b);
    }
}
