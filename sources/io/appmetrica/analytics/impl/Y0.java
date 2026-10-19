package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0644v1 f852a;

    public Y0(C0644v1 c0644v1) {
        this.f852a = c0644v1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.f852a).sendEventsBuffer();
    }
}
