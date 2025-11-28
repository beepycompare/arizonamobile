package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class P5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f631a;
    public final IHandlerExecutor b = C0620ua.k().x().a();
    public final WaitForActivationDelayBarrier c = C0620ua.k().a();

    public P5(List list) {
        this.f631a = list;
    }

    public static final void a(P5 p5) {
        for (Runnable runnable : p5.f631a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.P5$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                P5.a(P5.this);
            }
        });
    }
}
