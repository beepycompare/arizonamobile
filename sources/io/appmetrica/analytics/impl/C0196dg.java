package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0196dg implements InterfaceC0601tg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0247fg f852a;

    public C0196dg(C0247fg c0247fg) {
        this.f852a = c0247fg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0601tg
    public final void a(C0477og c0477og) {
        C0247fg c0247fg = this.f852a;
        C0247fg.a(c0247fg, c0477og, (Xf) c0247fg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0601tg
    public final void a(Throwable th) {
        C0247fg c0247fg = this.f852a;
        C0247fg.a(c0247fg, null, (Xf) c0247fg.e.getValue());
    }
}
