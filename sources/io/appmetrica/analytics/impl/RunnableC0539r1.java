package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0539r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1197a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0589t1 d;

    public RunnableC0539r1(C0589t1 c0589t1, String str, String str2, Throwable th) {
        this.d = c0589t1;
        this.f1197a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.d).reportError(this.f1197a, this.b, this.c);
    }
}
