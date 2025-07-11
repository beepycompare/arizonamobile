package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0419m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f931a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0494p1 c;

    public RunnableC0419m1(C0494p1 c0494p1, String str, Throwable th) {
        this.c = c0494p1;
        this.f931a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.c).reportError(this.f931a, this.b);
    }
}
