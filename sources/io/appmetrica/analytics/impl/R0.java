package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0502p1 f600a;

    public R0(C0502p1 c0502p1) {
        this.f600a = c0502p1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.f600a).sendEventsBuffer();
    }
}
