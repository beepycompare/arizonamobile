package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0258fk implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f859a;
    public final /* synthetic */ String b;

    public C0258fk(String str, String str2) {
        this.f859a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportEvent(this.f859a, this.b);
    }
}
