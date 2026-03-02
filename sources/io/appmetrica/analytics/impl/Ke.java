package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Ke implements InterfaceC0624uc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0546r9 f658a;
    public final C0599tc b;
    public final C0599tc c;

    public Ke(InterfaceC0546r9 interfaceC0546r9, Qg qg, C0467o4 c0467o4, We we) {
        this.f658a = interfaceC0546r9;
        C0599tc c0599tc = new C0599tc(qg, c0467o4, we);
        this.b = c0599tc;
        this.c = c0599tc;
        if (c0599tc.b()) {
            return;
        }
        C0448na.k().a().subscribe(TimeUnit.SECONDS.toMillis(I7.f624a.longValue()), C0448na.k().w().d(), this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0624uc
    public final F8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((C0368k5) this.f658a.a()).e();
    }
}
