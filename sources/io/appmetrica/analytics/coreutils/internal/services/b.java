package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper f290a;

    public b(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper) {
        this.f290a = activationBarrierHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.f290a.b;
        aVar.b.f288a = true;
        aVar.f289a.run();
    }
}
