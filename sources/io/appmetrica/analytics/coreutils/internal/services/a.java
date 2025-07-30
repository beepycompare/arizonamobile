package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
/* loaded from: classes4.dex */
public final class a implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f289a;
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper b;

    public a(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper, Runnable runnable) {
        this.b = activationBarrierHelper;
        this.f289a = runnable;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        this.b.f288a = true;
        this.f289a.run();
    }
}
