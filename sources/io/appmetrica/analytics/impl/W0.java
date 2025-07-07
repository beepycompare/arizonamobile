package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* loaded from: classes4.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f678a;
    public final /* synthetic */ C0502p1 b;

    public W0(C0502p1 c0502p1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0502p1;
        this.f678a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f983a.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        c0600t0.f().a(this.f678a);
    }
}
