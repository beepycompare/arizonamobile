package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0564s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1214a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0564s1(C0589t1 c0589t1, Throwable th) {
        this.b = c0589t1;
        this.f1214a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportUnhandledException(this.f1214a);
    }
}
