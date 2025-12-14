package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0585t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1223a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0585t1(C0610u1 c0610u1, Throwable th) {
        this.b = c0610u1;
        this.f1223a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportUnhandledException(this.f1223a);
    }
}
