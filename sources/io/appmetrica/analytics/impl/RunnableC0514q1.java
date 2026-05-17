package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0514q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1188a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0588t1 c;

    public RunnableC0514q1(C0588t1 c0588t1, String str, Throwable th) {
        this.c = c0588t1;
        this.f1188a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.c).reportError(this.f1188a, this.b);
    }
}
