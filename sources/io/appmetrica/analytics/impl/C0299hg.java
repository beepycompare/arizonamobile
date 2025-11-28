package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0299hg implements InterfaceC0701xg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0350jg f912a;

    public C0299hg(C0350jg c0350jg) {
        this.f912a = c0350jg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701xg
    public final void a(C0576sg c0576sg) {
        C0350jg c0350jg = this.f912a;
        C0350jg.a(c0350jg, c0576sg, (InterfaceC0144bg) c0350jg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701xg
    public final void a(Throwable th) {
        C0350jg c0350jg = this.f912a;
        C0350jg.a(c0350jg, null, (InterfaceC0144bg) c0350jg.e.getValue());
    }
}
