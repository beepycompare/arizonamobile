package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0524q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1044a;
    public final /* synthetic */ C0548r1 b;

    public RunnableC0524q1(C0548r1 c0548r1, Throwable th) {
        this.b = c0548r1;
        this.f1044a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).reportUnhandledException(this.f1044a);
    }
}
