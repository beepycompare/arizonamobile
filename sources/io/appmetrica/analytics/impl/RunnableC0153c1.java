package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0153c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f921a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0153c1(C0644v1 c0644v1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0644v1;
        this.f921a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1246a.getClass();
        A0 a0 = A0.e;
        a0.f().a(this.f921a);
    }
}
