package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0512q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1063a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0561s1 d;

    public RunnableC0512q1(C0561s1 c0561s1, String str, String str2, Throwable th) {
        this.d = c0561s1;
        this.f1063a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.d).reportError(this.f1063a, this.b, this.c);
    }
}
