package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes4.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f665a;
    public final /* synthetic */ C0502p1 b;

    public V0(C0502p1 c0502p1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0502p1;
        this.f665a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f983a.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        c0600t0.f().a(this.f665a);
    }
}
