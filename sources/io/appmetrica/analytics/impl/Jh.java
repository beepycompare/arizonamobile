package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Jh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f542a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0301hi d;

    public Jh(C0301hi c0301hi, String str, String str2, Throwable th) {
        this.d = c0301hi;
        this.f542a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.d;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportError(this.f542a, this.b, this.c);
    }
}
