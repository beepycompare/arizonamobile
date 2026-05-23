package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0160c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f915a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0160c1(C0651v1 c0651v1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0651v1;
        this.f915a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1240a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f915a);
    }
}
