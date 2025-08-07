package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f672a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0613ti c;

    public Uh(C0613ti c0613ti, String str, Throwable th) {
        this.c = c0613ti;
        this.f672a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportError(this.f672a, this.b);
    }
}
