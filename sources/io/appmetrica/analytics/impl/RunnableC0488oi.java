package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0488oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0612ti f989a;

    public RunnableC0488oi(C0612ti c0612ti) {
        this.f989a = c0612ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.f989a;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).sendEventsBuffer();
    }
}
