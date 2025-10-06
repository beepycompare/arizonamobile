package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0259fk implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f883a;
    public final /* synthetic */ String b;

    public C0259fk(String str, String str2) {
        this.f883a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.putAppEnvironmentValue(this.f883a, this.b);
    }
}
