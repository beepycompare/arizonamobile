package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0499p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1030a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0548r1 d;

    public RunnableC0499p1(C0548r1 c0548r1, String str, String str2, Throwable th) {
        this.d = c0548r1;
        this.f1030a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.d).reportError(this.f1030a, this.b, this.c);
    }
}
