package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f627a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0568ri c;

    public Sh(C0568ri c0568ri, String str, Throwable th) {
        this.c = c0568ri;
        this.f627a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportError(this.f627a, this.b);
    }
}
