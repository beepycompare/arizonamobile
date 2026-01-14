package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f841a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0279gi c;

    public Wh(C0279gi c0279gi, String str, byte[] bArr) {
        this.c = c0279gi;
        this.f841a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).setSessionExtra(this.f841a, this.b);
    }
}
