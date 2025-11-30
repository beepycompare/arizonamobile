package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f751a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0301hi c;

    public Xh(C0301hi c0301hi, String str, byte[] bArr) {
        this.c = c0301hi;
        this.f751a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.c;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).setSessionExtra(this.f751a, this.b);
    }
}
