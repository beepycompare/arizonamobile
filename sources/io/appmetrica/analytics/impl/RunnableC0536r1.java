package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0536r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1084a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0536r1(C0561s1 c0561s1, Throwable th) {
        this.b = c0561s1;
        this.f1084a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportUnhandledException(this.f1084a);
    }
}
