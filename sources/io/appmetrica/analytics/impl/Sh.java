package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f628a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0560ri c;

    public Sh(C0560ri c0560ri, String str, Throwable th) {
        this.c = c0560ri;
        this.f628a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportError(this.f628a, this.b);
    }
}
