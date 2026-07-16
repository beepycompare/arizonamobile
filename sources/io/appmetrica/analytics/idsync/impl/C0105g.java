package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0105g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f426a;

    public C0105g(h hVar) {
        this.f426a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        C0104f c0104f = this.f426a.g;
        if (c0104f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            c0104f = null;
        }
        c0104f.run();
    }
}
