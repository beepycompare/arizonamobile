package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0488ok implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1137a;
    public final /* synthetic */ String b;

    public C0488ok(String str, String str2) {
        this.f1137a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportEvent(this.f1137a, this.b);
    }
}
