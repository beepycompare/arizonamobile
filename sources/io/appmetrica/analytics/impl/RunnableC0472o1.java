package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0472o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f978a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0472o1(C0497p1 c0497p1, Throwable th) {
        this.b = c0497p1;
        this.f978a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).reportUnhandledException(this.f978a);
    }
}
