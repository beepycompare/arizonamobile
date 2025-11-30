package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f555a;
    public final /* synthetic */ C0301hi b;

    public Kh(C0301hi c0301hi, Throwable th) {
        this.b = c0301hi;
        this.f555a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportUnhandledException(this.f555a);
    }
}
