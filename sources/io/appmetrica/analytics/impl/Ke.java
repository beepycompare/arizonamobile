package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Ke implements InterfaceC0625uc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0547r9 f659a;
    public final C0600tc b;
    public final C0600tc c;

    public Ke(InterfaceC0547r9 interfaceC0547r9, Qg qg, C0468o4 c0468o4, We we) {
        this.f659a = interfaceC0547r9;
        C0600tc c0600tc = new C0600tc(qg, c0468o4, we);
        this.b = c0600tc;
        this.c = c0600tc;
        if (c0600tc.b()) {
            return;
        }
        C0449na.k().a().subscribe(TimeUnit.SECONDS.toMillis(I7.f625a.longValue()), C0449na.k().w().d(), this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0625uc
    public final F8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((C0369k5) this.f659a.a()).e();
    }
}
