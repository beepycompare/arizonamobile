package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f840a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C0278gi c;

    public Wh(C0278gi c0278gi, String str, byte[] bArr) {
        this.c = c0278gi;
        this.f840a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.c;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).setSessionExtra(this.f840a, this.b);
    }
}
