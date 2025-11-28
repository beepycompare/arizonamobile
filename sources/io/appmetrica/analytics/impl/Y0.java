package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f762a;
    public final /* synthetic */ C0561s1 b;

    public Y0(C0561s1 c0561s1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c0561s1;
        this.f762a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f1103a.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        c0660w0.f().a(this.f762a);
    }
}
