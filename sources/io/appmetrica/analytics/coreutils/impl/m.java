package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
/* loaded from: classes5.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivationBarrierCallback f347a;

    public m(ActivationBarrierCallback activationBarrierCallback) {
        this.f347a = activationBarrierCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f347a.onWaitFinished();
    }
}
