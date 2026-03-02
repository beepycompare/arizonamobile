package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.cg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0173cg implements InterfaceC0578sg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0224eg f939a;

    public C0173cg(C0224eg c0224eg) {
        this.f939a = c0224eg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0578sg
    public final void a(C0454ng c0454ng) {
        C0224eg c0224eg = this.f939a;
        C0224eg.a(c0224eg, c0454ng, (Wf) c0224eg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0578sg
    public final void a(Throwable th) {
        C0224eg c0224eg = this.f939a;
        C0224eg.a(c0224eg, null, (Wf) c0224eg.e.getValue());
    }
}
