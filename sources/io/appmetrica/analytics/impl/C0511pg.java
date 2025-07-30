package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0511pg implements Fg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560rg f1003a;

    public C0511pg(C0560rg c0560rg) {
        this.f1003a = c0560rg;
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Ag ag) {
        C0560rg c0560rg = this.f1003a;
        C0560rg.a(c0560rg, ag, (InterfaceC0361jg) c0560rg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Fg
    public final void a(Throwable th) {
        C0560rg c0560rg = this.f1003a;
        C0560rg.a(c0560rg, null, (InterfaceC0361jg) c0560rg.e.getValue());
    }
}
