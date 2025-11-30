package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0536r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1096a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0611u1 c;

    public RunnableC0536r1(C0611u1 c0611u1, String str, Throwable th) {
        this.c = c0611u1;
        this.f1096a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.c).reportError(this.f1096a, this.b);
    }
}
