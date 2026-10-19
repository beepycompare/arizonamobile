package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0098g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f429a;

    public C0098g(h hVar) {
        this.f429a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        C0097f c0097f = this.f429a.g;
        if (c0097f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            c0097f = null;
        }
        c0097f.run();
    }
}
