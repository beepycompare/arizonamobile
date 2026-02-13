package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0515q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1183a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0589t1 c;

    public RunnableC0515q1(C0589t1 c0589t1, String str, Throwable th) {
        this.c = c0589t1;
        this.f1183a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.c).reportError(this.f1183a, this.b);
    }
}
