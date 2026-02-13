package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.cg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0174cg implements InterfaceC0579sg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0225eg f939a;

    public C0174cg(C0225eg c0225eg) {
        this.f939a = c0225eg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0579sg
    public final void a(C0455ng c0455ng) {
        C0225eg c0225eg = this.f939a;
        C0225eg.a(c0225eg, c0455ng, (Wf) c0225eg.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0579sg
    public final void a(Throwable th) {
        C0225eg c0225eg = this.f939a;
        C0225eg.a(c0225eg, null, (Wf) c0225eg.e.getValue());
    }
}
