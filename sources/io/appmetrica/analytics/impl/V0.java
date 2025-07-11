package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes4.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f666a;
    public final /* synthetic */ C0494p1 b;

    public V0(C0494p1 c0494p1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0494p1;
        this.f666a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f984a.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        c0592t0.f().a(this.f666a);
    }
}
