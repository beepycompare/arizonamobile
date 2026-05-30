package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper f376a;

    public b(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper) {
        this.f376a = activationBarrierHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.f376a.b;
        aVar.b.f374a = true;
        aVar.f375a.run();
    }
}
