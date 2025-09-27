package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0472o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1014a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0547r1 c;

    public RunnableC0472o1(C0547r1 c0547r1, String str, Throwable th) {
        this.c = c0547r1;
        this.f1014a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.c).reportError(this.f1014a, this.b);
    }
}
