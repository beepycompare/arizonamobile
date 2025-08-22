package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0232ek implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f845a;

    public C0232ek(String str) {
        this.f845a = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportEvent(this.f845a);
    }
}
