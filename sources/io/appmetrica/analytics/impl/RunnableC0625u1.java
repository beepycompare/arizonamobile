package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.u1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0625u1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1221a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0625u1(C0651v1 c0651v1, Throwable th) {
        this.b = c0651v1;
        this.f1221a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).reportUnhandledException(this.f1221a);
    }
}
