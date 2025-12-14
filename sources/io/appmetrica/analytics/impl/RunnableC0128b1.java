package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0128b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f904a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0128b1(C0610u1 c0610u1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0610u1;
        this.f904a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1238a.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        c0709y0.f().a(this.f904a);
    }
}
