package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f778a;
    public final /* synthetic */ C0561s1 b;

    public Z0(C0561s1 c0561s1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c0561s1;
        this.f778a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1103a.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        c0660w0.f().a(this.f778a);
    }
}
