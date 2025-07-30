package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ye implements Pc {

    /* renamed from: a  reason: collision with root package name */
    public final Oc f736a;
    public final Oc b;

    public Ye(final M9 m9, C0211dh c0211dh, J4 j4, C0385kf c0385kf) {
        Oc oc = new Oc(c0211dh, j4, c0385kf);
        this.f736a = oc;
        this.b = oc;
        if (oc.b()) {
            return;
        }
        Ia.j().a().subscribe(TimeUnit.SECONDS.toMillis(AbstractC0176c8.f797a.longValue()), Ia.j().w().a(), new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.Ye$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                Ye.a(Ye.this, m9);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final Y8 a() {
        return this.b;
    }

    public static final void a(Ye ye, M9 m9) {
        ye.f736a.a();
        ((F5) m9.a()).e();
    }
}
