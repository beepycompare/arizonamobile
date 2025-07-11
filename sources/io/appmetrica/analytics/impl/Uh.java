package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f661a;
    public final /* synthetic */ C0560ri b;

    public Uh(C0560ri c0560ri, Throwable th) {
        this.b = c0560ri;
        this.f661a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportUnhandledException(this.f661a);
    }
}
