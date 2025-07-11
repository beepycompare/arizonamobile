package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.b6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0148b6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f766a;
    public final IHandlerExecutor b = Ga.j().w().a();
    public final WaitForActivationDelayBarrier c = Ga.j().a();

    public RunnableC0148b6(List list) {
        this.f766a = list;
    }

    public static final void a(RunnableC0148b6 runnableC0148b6) {
        for (Runnable runnable : runnableC0148b6.f766a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.b6$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                RunnableC0148b6.a(RunnableC0148b6.this);
            }
        });
    }
}
