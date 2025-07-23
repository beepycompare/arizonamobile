package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* loaded from: classes4.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f692a;
    public final /* synthetic */ C0496p1 b;

    public W0(C0496p1 c0496p1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0496p1;
        this.f692a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f994a.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        c0594t0.f().a(this.f692a);
    }
}
