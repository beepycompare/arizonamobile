package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0486oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560ri f976a;

    public RunnableC0486oi(C0560ri c0560ri) {
        this.f976a = c0560ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.f976a;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).clearAppEnvironment();
    }
}
