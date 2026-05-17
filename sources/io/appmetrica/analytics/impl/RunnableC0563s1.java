package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0563s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1219a;
    public final /* synthetic */ C0588t1 b;

    public RunnableC0563s1(C0588t1 c0588t1, Throwable th) {
        this.b = c0588t1;
        this.f1219a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).reportUnhandledException(this.f1219a);
    }
}
