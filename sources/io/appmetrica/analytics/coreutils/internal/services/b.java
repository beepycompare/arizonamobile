package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper f375a;

    public b(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper) {
        this.f375a = activationBarrierHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.f375a.b;
        aVar.b.f373a = true;
        aVar.f374a.run();
    }
}
