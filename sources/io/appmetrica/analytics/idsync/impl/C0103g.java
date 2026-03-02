package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.g  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0103g implements ActivationBarrierCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f468a;

    public C0103g(h hVar) {
        this.f468a = hVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
    public final void onWaitFinished() {
        C0102f c0102f = this.f468a.g;
        if (c0102f == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
            c0102f = null;
        }
        c0102f.run();
    }
}
