package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0512pg implements Fg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561rg f1002a;

    public C0512pg(C0561rg c0561rg) {
        this.f1002a = c0561rg;
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Ag ag) {
        C0561rg c0561rg = this.f1002a;
        C0561rg.a(c0561rg, ag, (InterfaceC0362jg) c0561rg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Throwable th) {
        C0561rg c0561rg = this.f1002a;
        C0561rg.a(c0561rg, null, (InterfaceC0362jg) c0561rg.e.getValue());
    }
}
