package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f652a;
    public final /* synthetic */ C0300hi b;

    public Kh(C0300hi c0300hi, Throwable th) {
        this.b = c0300hi;
        this.f652a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportUnhandledException(this.f652a);
    }
}
