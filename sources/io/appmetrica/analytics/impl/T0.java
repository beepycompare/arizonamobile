package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0547r1 f677a;

    public T0(C0547r1 c0547r1) {
        this.f677a = c0547r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.f677a).sendEventsBuffer();
    }
}
