package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivationBarrierCallback f273a;

    public m(ActivationBarrierCallback activationBarrierCallback) {
        this.f273a = activationBarrierCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f273a.onWaitFinished();
    }
}
