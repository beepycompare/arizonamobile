package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0127b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f902a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0127b1(C0644v1 c0644v1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0644v1;
        this.f902a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1246a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f902a);
    }
}
