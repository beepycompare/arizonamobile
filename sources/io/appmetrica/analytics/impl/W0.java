package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0588t1 f837a;

    public W0(C0588t1 c0588t1) {
        this.f837a = c0588t1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.f837a).sendEventsBuffer();
    }
}
