package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f704a;
    public final /* synthetic */ C0612ti b;

    public Wh(C0612ti c0612ti, Throwable th) {
        this.b = c0612ti;
        this.f704a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).reportUnhandledException(this.f704a);
    }
}
