package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Le implements InterfaceC0647vc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0569s9 f570a;
    public final C0622uc b;
    public final C0622uc c;

    public Le(InterfaceC0569s9 interfaceC0569s9, Rg rg, C0490p4 c0490p4, Xe xe) {
        this.f570a = interfaceC0569s9;
        C0622uc c0622uc = new C0622uc(rg, c0490p4, xe);
        this.b = c0622uc;
        this.c = c0622uc;
        if (c0622uc.b()) {
            return;
        }
        C0471oa.k().a().subscribe(TimeUnit.SECONDS.toMillis(J7.f536a.longValue()), C0471oa.k().w().d(), this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0647vc
    public final G8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((C0391l5) this.f570a.a()).e();
    }
}
