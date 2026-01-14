package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0589t1 f833a;

    public W0(C0589t1 c0589t1) {
        this.f833a = c0589t1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.f833a).sendEventsBuffer();
    }
}
