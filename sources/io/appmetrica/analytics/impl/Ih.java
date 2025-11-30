package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f525a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0301hi c;

    public Ih(C0301hi c0301hi, String str, Throwable th) {
        this.c = c0301hi;
        this.f525a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.c;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportError(this.f525a, this.b);
    }
}
