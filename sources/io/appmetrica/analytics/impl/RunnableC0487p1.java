package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0487p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1048a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0561s1 c;

    public RunnableC0487p1(C0561s1 c0561s1, String str, Throwable th) {
        this.c = c0561s1;
        this.f1048a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.c).reportError(this.f1048a, this.b);
    }
}
