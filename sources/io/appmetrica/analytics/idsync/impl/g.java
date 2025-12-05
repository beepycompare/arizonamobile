package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f450a;

    public g(h hVar) {
        this.f450a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        f fVar = this.f450a.g;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            fVar = null;
        }
        fVar.run();
    }
}
