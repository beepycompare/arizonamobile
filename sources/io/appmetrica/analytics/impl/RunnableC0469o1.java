package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0469o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f965a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0469o1(C0494p1 c0494p1, Throwable th) {
        this.b = c0494p1;
        this.f965a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportUnhandledException(this.f965a);
    }
}
