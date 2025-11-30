package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0586t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1126a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0586t1(C0611u1 c0611u1, Throwable th) {
        this.b = c0611u1;
        this.f1126a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportUnhandledException(this.f1126a);
    }
}
