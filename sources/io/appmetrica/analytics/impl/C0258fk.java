package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0258fk implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f883a;
    public final /* synthetic */ String b;

    public C0258fk(String str, String str2) {
        this.f883a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.putAppEnvironmentValue(this.f883a, this.b);
    }
}
