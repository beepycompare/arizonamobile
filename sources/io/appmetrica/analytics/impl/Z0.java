package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f875a;
    public final /* synthetic */ C0589t1 b;

    public Z0(C0589t1 c0589t1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0589t1;
        this.f875a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1228a.getClass();
        C0713y0 c0713y0 = C0713y0.e;
        c0713y0.f().a(this.f875a);
    }
}
