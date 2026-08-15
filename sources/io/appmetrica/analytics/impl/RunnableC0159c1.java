package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0159c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f918a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0159c1(C0650v1 c0650v1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0650v1;
        this.f918a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1243a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f918a);
    }
}
