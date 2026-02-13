package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0107a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f894a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0107a1(C0589t1 c0589t1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0589t1;
        this.f894a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1228a.getClass();
        C0713y0 c0713y0 = C0713y0.e;
        c0713y0.f().a(this.f894a);
    }
}
