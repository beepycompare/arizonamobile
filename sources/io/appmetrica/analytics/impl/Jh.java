package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Jh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f640a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0300hi d;

    public Jh(C0300hi c0300hi, String str, String str2, Throwable th) {
        this.d = c0300hi;
        this.f640a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.d;
        C0300hi.a(c0300hi.f1024a, c0300hi.d, c0300hi.e).reportError(this.f640a, this.b, this.c);
    }
}
