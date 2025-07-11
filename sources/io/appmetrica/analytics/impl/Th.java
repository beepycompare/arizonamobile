package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f644a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0560ri d;

    public Th(C0560ri c0560ri, String str, String str2, Throwable th) {
        this.d = c0560ri;
        this.f644a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.d;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportError(this.f644a, this.b, this.c);
    }
}
