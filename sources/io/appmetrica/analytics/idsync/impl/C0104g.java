package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.g  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0104g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f469a;

    public C0104g(h hVar) {
        this.f469a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        C0103f c0103f = this.f469a.g;
        if (c0103f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            c0103f = null;
        }
        c0103f.run();
    }
}
