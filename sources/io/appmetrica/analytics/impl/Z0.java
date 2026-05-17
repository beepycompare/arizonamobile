package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f880a;
    public final /* synthetic */ C0588t1 b;

    public Z0(C0588t1 c0588t1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0588t1;
        this.f880a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1233a.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        c0712y0.f().a(this.f880a);
    }
}
