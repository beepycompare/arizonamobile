package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0171ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0300hi f932a;

    public RunnableC0171ci(C0300hi c0300hi) {
        this.f932a = c0300hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.f932a;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).sendEventsBuffer();
    }
}
