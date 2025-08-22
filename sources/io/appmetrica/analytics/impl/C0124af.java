package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0124af implements Rc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final O9 f778a;
    public final Qc b;
    public final Qc c;

    public C0124af(O9 o9, C0332ih c0332ih, J4 j4, C0433mf c0433mf) {
        this.f778a = o9;
        Qc qc = new Qc(c0332ih, j4, c0433mf);
        this.b = qc;
        this.c = qc;
        if (qc.b()) {
            return;
        }
        Ka.j().a().subscribe(TimeUnit.SECONDS.toMillis(AbstractC0195d8.f826a.longValue()), Ka.j().w().a(), this);
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final InterfaceC0118a9 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((F5) this.f778a.a()).e();
    }
}
