package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0342ig implements Dg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0517pg f877a;

    public C0342ig(C0517pg c0517pg) {
        this.f877a = c0517pg;
    }

    @Override // io.appmetrica.analytics.impl.Dg
    public final void a(C0741yg c0741yg) {
        C0517pg c0517pg = this.f877a;
        C0517pg.a(c0517pg, c0741yg, (InterfaceC0318hg) c0517pg.d.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Dg
    public final void a(Throwable th) {
        C0517pg c0517pg = this.f877a;
        C0517pg.a(c0517pg, null, (InterfaceC0318hg) c0517pg.d.getValue());
    }
}
