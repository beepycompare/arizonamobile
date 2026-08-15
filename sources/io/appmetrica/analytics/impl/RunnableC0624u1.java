package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.u1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0624u1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1224a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0624u1(C0650v1 c0650v1, Throwable th) {
        this.b = c0650v1;
        this.f1224a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportUnhandledException(this.f1224a);
    }
}
