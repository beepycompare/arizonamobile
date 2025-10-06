package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f734a;
    public final /* synthetic */ C0548r1 b;

    public X0(C0548r1 c0548r1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0548r1;
        this.f734a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1059a.getClass();
        C0647v0 c0647v0 = C0647v0.e;
        c0647v0.f().a(this.f734a);
    }
}
