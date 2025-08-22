package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0218e6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f839a;
    public final IHandlerExecutor b = Ka.j().w().a();
    public final WaitForActivationDelayBarrier c = Ka.j().a();

    public RunnableC0218e6(List list) {
        this.f839a = list;
    }

    public static final void a(RunnableC0218e6 runnableC0218e6) {
        for (Runnable runnable : runnableC0218e6.f839a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.e6$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                RunnableC0218e6.a(RunnableC0218e6.this);
            }
        });
    }
}
