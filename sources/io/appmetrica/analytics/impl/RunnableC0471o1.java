package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0471o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f979a;
    public final /* synthetic */ C0496p1 b;

    public RunnableC0471o1(C0496p1 c0496p1, Throwable th) {
        this.b = c0496p1;
        this.f979a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).reportUnhandledException(this.f979a);
    }
}
