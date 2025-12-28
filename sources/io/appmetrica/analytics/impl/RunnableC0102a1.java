package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0102a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f886a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0102a1(C0610u1 c0610u1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0610u1;
        this.f886a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1239a.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        c0709y0.f().a(this.f886a);
    }
}
