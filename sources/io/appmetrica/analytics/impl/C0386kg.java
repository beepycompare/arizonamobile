package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0386kg implements Fg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560rg f926a;

    public C0386kg(C0560rg c0560rg) {
        this.f926a = c0560rg;
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Ag ag) {
        C0560rg c0560rg = this.f926a;
        C0560rg.a(c0560rg, ag, (InterfaceC0361jg) c0560rg.d.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Throwable th) {
        C0560rg c0560rg = this.f926a;
        C0560rg.a(c0560rg, null, (InterfaceC0361jg) c0560rg.d.getValue());
    }
}
