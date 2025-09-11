package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f733a;
    public final /* synthetic */ C0547r1 b;

    public X0(C0547r1 c0547r1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0547r1;
        this.f733a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1058a.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        c0646v0.f().a(this.f733a);
    }
}
