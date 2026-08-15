package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0133b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f899a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0133b1(C0650v1 c0650v1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0650v1;
        this.f899a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1243a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f899a);
    }
}
