package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0134b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f897a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0134b1(C0651v1 c0651v1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0651v1;
        this.f897a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1241a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f897a);
    }
}
