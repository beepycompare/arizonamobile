package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class I5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f623a;
    public final IHandlerExecutor b = C0448na.k().w().a();
    public final WaitForActivationDelayBarrier c = C0448na.k().a();

    public I5(List list) {
        this.f623a = list;
    }

    public static final void a(I5 i5) {
        for (Runnable runnable : i5.f623a) {
            runnable.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.I5$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                I5.a(I5.this);
            }
        });
    }
}
