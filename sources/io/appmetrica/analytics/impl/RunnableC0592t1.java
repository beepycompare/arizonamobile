package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0592t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1211a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0644v1 d;

    public RunnableC0592t1(C0644v1 c0644v1, String str, String str2, Throwable th) {
        this.d = c0644v1;
        this.f1211a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.d).reportError(this.f1211a, this.b, this.c);
    }
}
