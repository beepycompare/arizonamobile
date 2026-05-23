package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.lf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0406lf implements Vc, ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final L9 f1079a;
    public final Uc b;
    public final Uc c;

    public C0406lf(L9 l9, C0279gh c0279gh, F4 f4, C0691wf c0691wf) {
        this.f1079a = l9;
        Uc uc = new Uc(c0279gh, f4, c0691wf);
        this.b = uc;
        this.c = uc;
        if (uc.b()) {
            return;
        }
        Na.k().a().subscribe(TimeUnit.SECONDS.toMillis(AbstractC0115a8.f882a.longValue()), Na.k().w().f(), this);
    }

    @Override // io.appmetrica.analytics.impl.Vc
    public final Z8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.a();
        ((A5) this.f1079a.a()).e();
    }
}
