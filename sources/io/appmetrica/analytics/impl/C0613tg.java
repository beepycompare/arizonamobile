package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0613tg implements Og {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ag f1097a;

    public C0613tg(Ag ag) {
        this.f1097a = ag;
    }

    @Override // io.appmetrica.analytics.impl.Og
    public final void a(Jg jg) {
        Ag ag = this.f1097a;
        Ag.a(ag, jg, (InterfaceC0588sg) ag.d.getValue());
    }

    @Override // io.appmetrica.analytics.impl.Og
    public final void a(Throwable th) {
        Ag ag = this.f1097a;
        Ag.a(ag, null, (InterfaceC0588sg) ag.d.getValue());
    }
}
