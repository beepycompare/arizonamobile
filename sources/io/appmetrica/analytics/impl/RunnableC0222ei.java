package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0222ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0300hi f970a;

    public RunnableC0222ei(C0300hi c0300hi) {
        this.f970a = c0300hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.f970a;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).clearAppEnvironment();
    }
}
