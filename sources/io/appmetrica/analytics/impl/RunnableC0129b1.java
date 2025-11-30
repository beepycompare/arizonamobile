package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0129b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f807a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0129b1(C0611u1 c0611u1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0611u1;
        this.f807a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1141a.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        c0710y0.f().a(this.f807a);
    }
}
