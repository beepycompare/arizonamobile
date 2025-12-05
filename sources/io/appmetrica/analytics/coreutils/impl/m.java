package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
/* loaded from: classes3.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivationBarrierCallback f381a;

    public m(ActivationBarrierCallback activationBarrierCallback) {
        this.f381a = activationBarrierCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f381a.onWaitFinished();
    }
}
