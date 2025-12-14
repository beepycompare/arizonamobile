package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Le implements InterfaceC0646vc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0568s9 f667a;
    public final C0621uc b;
    public final C0621uc c;

    public Le(InterfaceC0568s9 interfaceC0568s9, Rg rg, C0489p4 c0489p4, Xe xe) {
        this.f667a = interfaceC0568s9;
        C0621uc c0621uc = new C0621uc(rg, c0489p4, xe);
        this.b = c0621uc;
        this.c = c0621uc;
        if (c0621uc.b()) {
            return;
        }
        C0470oa.k().a().subscribe(TimeUnit.SECONDS.toMillis(J7.f633a.longValue()), C0470oa.k().w().d(), this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0646vc
    public final G8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((C0390l5) this.f667a.a()).e();
    }
}
