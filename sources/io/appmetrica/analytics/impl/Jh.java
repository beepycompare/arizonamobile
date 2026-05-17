package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Jh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f649a;
    public final /* synthetic */ C0278gi b;

    public Jh(C0278gi c0278gi, Throwable th) {
        this.b = c0278gi;
        this.f649a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportUnhandledException(this.f649a);
    }
}
