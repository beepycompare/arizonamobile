package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper f405a;

    public b(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper) {
        this.f405a = activationBarrierHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.f405a.b;
        aVar.b.f403a = true;
        aVar.f404a.run();
    }
}
