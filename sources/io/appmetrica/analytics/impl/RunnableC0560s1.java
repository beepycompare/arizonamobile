package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0560s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1207a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0610u1 d;

    public RunnableC0560s1(C0610u1 c0610u1, String str, String str2, Throwable th) {
        this.d = c0610u1;
        this.f1207a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.d).reportError(this.f1207a, this.b, this.c);
    }
}
