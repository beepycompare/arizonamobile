package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivationBarrierCallback f264a;

    public m(ActivationBarrierCallback activationBarrierCallback) {
        this.f264a = activationBarrierCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f264a.onWaitFinished();
    }
}
