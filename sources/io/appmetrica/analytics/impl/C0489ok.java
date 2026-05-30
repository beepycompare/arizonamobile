package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0489ok implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1135a;
    public final /* synthetic */ String b;

    public C0489ok(String str, String str2) {
        this.f1135a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportEvent(this.f1135a, this.b);
    }
}
