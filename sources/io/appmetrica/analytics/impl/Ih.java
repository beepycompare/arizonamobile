package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f622a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0300hi c;

    public Ih(C0300hi c0300hi, String str, Throwable th) {
        this.c = c0300hi;
        this.f622a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportError(this.f622a, this.b);
    }
}
