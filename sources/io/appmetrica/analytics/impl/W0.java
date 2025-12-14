package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0610u1 f827a;

    public W0(C0610u1 c0610u1) {
        this.f827a = c0610u1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.f827a).sendEventsBuffer();
    }
}
