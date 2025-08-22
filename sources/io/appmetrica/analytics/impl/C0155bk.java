package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0155bk implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f798a;
    public final /* synthetic */ String b;

    public C0155bk(String str, String str2) {
        this.f798a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.putAppEnvironmentValue(this.f798a, this.b);
    }
}
