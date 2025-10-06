package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* loaded from: classes4.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f751a;
    public final /* synthetic */ C0548r1 b;

    public Y0(C0548r1 c0548r1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0548r1;
        this.f751a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1059a.getClass();
        C0647v0 c0647v0 = C0647v0.e;
        c0647v0.f().a(this.f751a);
    }
}
