package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* loaded from: classes4.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f679a;
    public final /* synthetic */ C0494p1 b;

    public W0(C0494p1 c0494p1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0494p1;
        this.f679a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f984a.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        c0592t0.f().a(this.f679a);
    }
}
