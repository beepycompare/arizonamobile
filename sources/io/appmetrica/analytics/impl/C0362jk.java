package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.jk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0362jk implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f943a;
    public final /* synthetic */ String b;

    public C0362jk(String str, String str2) {
        this.f943a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportEvent(this.f943a, this.b);
    }
}
