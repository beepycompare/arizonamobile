package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0447n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f962a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0497p1 d;

    public RunnableC0447n1(C0497p1 c0497p1, String str, String str2, Throwable th) {
        this.d = c0497p1;
        this.f962a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.d).reportError(this.f962a, this.b, this.c);
    }
}
