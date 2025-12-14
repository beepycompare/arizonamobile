package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f848a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0300hi c;

    public Xh(C0300hi c0300hi, String str, byte[] bArr) {
        this.c = c0300hi;
        this.f848a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).setSessionExtra(this.f848a, this.b);
    }
}
