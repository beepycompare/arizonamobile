package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f643a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0568ri d;

    public Th(C0568ri c0568ri, String str, String str2, Throwable th) {
        this.d = c0568ri;
        this.f643a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.d;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportError(this.f643a, this.b, this.c);
    }
}
