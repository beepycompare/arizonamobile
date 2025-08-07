package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f703a;
    public final /* synthetic */ C0613ti b;

    public Wh(C0613ti c0613ti, Throwable th) {
        this.b = c0613ti;
        this.f703a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportUnhandledException(this.f703a);
    }
}
