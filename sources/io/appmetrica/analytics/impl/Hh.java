package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f615a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0279gi c;

    public Hh(C0279gi c0279gi, String str, Throwable th) {
        this.c = c0279gi;
        this.f615a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportError(this.f615a, this.b);
    }
}
