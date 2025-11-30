package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f367a;

    public g(h hVar) {
        this.f367a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        f fVar = this.f367a.g;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            fVar = null;
        }
        fVar.run();
    }
}
