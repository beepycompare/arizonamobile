package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0296h6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f903a;
    public final IHandlerExecutor b = Na.j().w().a();
    public final WaitForActivationDelayBarrier c = Na.j().a();

    public RunnableC0296h6(List list) {
        this.f903a = list;
    }

    public static final void a(RunnableC0296h6 runnableC0296h6) {
        for (Runnable runnable : runnableC0296h6.f903a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.h6$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                RunnableC0296h6.a(RunnableC0296h6.this);
            }
        });
    }
}
