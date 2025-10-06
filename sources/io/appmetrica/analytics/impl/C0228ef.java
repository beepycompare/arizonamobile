package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0228ef implements Uc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final R9 f862a;
    public final Tc b;
    public final Tc c;

    public C0228ef(R9 r9, C0437mh c0437mh, M4 m4, C0538qf c0538qf) {
        this.f862a = r9;
        Tc tc = new Tc(c0437mh, m4, c0538qf);
        this.b = tc;
        this.c = tc;
        if (tc.b()) {
            return;
        }
        Na.j().a().subscribe(TimeUnit.SECONDS.toMillis(AbstractC0273g8.f892a.longValue()), Na.j().w().a(), this);
    }

    @Override // io.appmetrica.analytics.impl.Uc
    public final InterfaceC0197d9 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((I5) this.f862a.a()).e();
    }
}
