package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0494oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0568ri f975a;

    public RunnableC0494oi(C0568ri c0568ri) {
        this.f975a = c0568ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.f975a;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).clearAppEnvironment();
    }
}
