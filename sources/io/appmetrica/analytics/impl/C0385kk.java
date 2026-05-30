package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0385kk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1069a;
    public final /* synthetic */ String b;

    public C0385kk(String str, String str2) {
        this.f1069a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.putAppEnvironmentValue(this.f1069a, this.b);
    }
}
