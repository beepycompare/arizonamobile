package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0282gk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1000a;
    public final /* synthetic */ byte[] b;

    public C0282gk(String str, byte[] bArr) {
        this.f1000a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.setSessionExtra(this.f1000a, this.b);
    }
}
