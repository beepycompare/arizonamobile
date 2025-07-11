package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0436mi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560ri f942a;

    public RunnableC0436mi(C0560ri c0560ri) {
        this.f942a = c0560ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.f942a;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).sendEventsBuffer();
    }
}
