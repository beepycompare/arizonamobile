package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0172ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0301hi f835a;

    public RunnableC0172ci(C0301hi c0301hi) {
        this.f835a = c0301hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.f835a;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).sendEventsBuffer();
    }
}
