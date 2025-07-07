package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0477o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f964a;
    public final /* synthetic */ C0502p1 b;

    public RunnableC0477o1(C0502p1 c0502p1, Throwable th) {
        this.b = c0502p1;
        this.f964a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportUnhandledException(this.f964a);
    }
}
