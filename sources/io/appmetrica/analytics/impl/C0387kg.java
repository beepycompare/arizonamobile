package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0387kg implements Fg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561rg f926a;

    public C0387kg(C0561rg c0561rg) {
        this.f926a = c0561rg;
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Ag ag) {
        C0561rg c0561rg = this.f926a;
        C0561rg.a(c0561rg, ag, (InterfaceC0362jg) c0561rg.d.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Throwable th) {
        C0561rg c0561rg = this.f926a;
        C0561rg.a(c0561rg, null, (InterfaceC0362jg) c0561rg.d.getValue());
    }
}
