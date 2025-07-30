package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes4.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f679a;
    public final /* synthetic */ C0496p1 b;

    public V0(C0496p1 c0496p1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0496p1;
        this.f679a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f995a.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        c0594t0.f().a(this.f679a);
    }
}
