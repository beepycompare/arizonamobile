package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f619a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0278gi c;

    public Hh(C0278gi c0278gi, String str, Throwable th) {
        this.c = c0278gi;
        this.f619a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.c;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportError(this.f619a, this.b);
    }
}
