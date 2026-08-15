package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0598t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1208a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0650v1 d;

    public RunnableC0598t1(C0650v1 c0650v1, String str, String str2, Throwable th) {
        this.d = c0650v1;
        this.f1208a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.d).reportError(this.f1208a, this.b, this.c);
    }
}
