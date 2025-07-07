package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0444mi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0568ri f941a;

    public RunnableC0444mi(C0568ri c0568ri) {
        this.f941a = c0568ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.f941a;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).sendEventsBuffer();
    }
}
