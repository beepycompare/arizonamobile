package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class We implements Nc {

    /* renamed from: a  reason: collision with root package name */
    public final Mc f688a;
    public final Mc b;

    public We(final J9 j9, C0167bh c0167bh, J4 j4, Cif cif) {
        Mc mc = new Mc(c0167bh, j4, cif);
        this.f688a = mc;
        this.b = mc;
        if (mc.b()) {
            return;
        }
        Ga.j().a().subscribe(TimeUnit.SECONDS.toMillis(Z7.f733a.longValue()), Ga.j().w().a(), new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.We$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                We.a(We.this, j9);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.Nc
    public final V8 a() {
        return this.b;
    }

    public static final void a(We we, J9 j9) {
        we.f688a.a();
        ((D5) j9.a()).e();
    }
}
