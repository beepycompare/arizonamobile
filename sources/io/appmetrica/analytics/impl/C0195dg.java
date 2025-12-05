package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0195dg implements InterfaceC0600tg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0246fg f935a;

    public C0195dg(C0246fg c0246fg) {
        this.f935a = c0246fg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0600tg
    public final void a(C0476og c0476og) {
        C0246fg c0246fg = this.f935a;
        C0246fg.a(c0246fg, c0476og, (Xf) c0246fg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0600tg
    public final void a(Throwable th) {
        C0246fg c0246fg = this.f935a;
        C0246fg.a(c0246fg, null, (Xf) c0246fg.e.getValue());
    }
}
