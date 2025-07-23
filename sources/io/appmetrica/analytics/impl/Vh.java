package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f688a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0612ti d;

    public Vh(C0612ti c0612ti, String str, String str2, Throwable th) {
        this.d = c0612ti;
        this.f688a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.d;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportError(this.f688a, this.b, this.c);
    }
}
