package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class J5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f633a;
    public final IHandlerExecutor b = C0470oa.k().w().a();
    public final WaitForActivationDelayBarrier c = C0470oa.k().a();

    public J5(List list) {
        this.f633a = list;
    }

    public static final void a(J5 j5) {
        for (Runnable runnable : j5.f633a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.J5$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                J5.a(J5.this);
            }
        });
    }
}
