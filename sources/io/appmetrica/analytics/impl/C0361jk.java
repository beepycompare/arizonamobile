package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.jk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0361jk implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f942a;
    public final /* synthetic */ String b;

    public C0361jk(String str, String str2) {
        this.f942a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportEvent(this.f942a, this.b);
    }
}
