package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0482ok implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1140a;
    public final /* synthetic */ String b;

    public C0482ok(String str, String str2) {
        this.f1140a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportEvent(this.f1140a, this.b);
    }
}
