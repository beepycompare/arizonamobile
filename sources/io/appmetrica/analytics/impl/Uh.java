package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f673a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0612ti c;

    public Uh(C0612ti c0612ti, String str, Throwable th) {
        this.c = c0612ti;
        this.f673a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.c;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).reportError(this.f673a, this.b);
    }
}
