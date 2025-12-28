package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0535r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1194a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0535r1(C0610u1 c0610u1, String str, Throwable th) {
        this.c = c0610u1;
        this.f1194a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.c).reportError(this.f1194a, this.b);
    }
}
