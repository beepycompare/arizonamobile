package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0281gk implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1002a;
    public final /* synthetic */ byte[] b;

    public C0281gk(String str, byte[] bArr) {
        this.f1002a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.setSessionExtra(this.f1002a, this.b);
    }
}
