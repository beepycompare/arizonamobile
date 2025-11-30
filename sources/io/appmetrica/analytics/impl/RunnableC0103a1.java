package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0103a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f788a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0103a1(C0611u1 c0611u1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0611u1;
        this.f788a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1141a.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        c0710y0.f().a(this.f788a);
    }
}
