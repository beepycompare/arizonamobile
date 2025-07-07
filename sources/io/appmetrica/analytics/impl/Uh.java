package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f660a;
    public final /* synthetic */ C0568ri b;

    public Uh(C0568ri c0568ri, Throwable th) {
        this.b = c0568ri;
        this.f660a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportUnhandledException(this.f660a);
    }
}
