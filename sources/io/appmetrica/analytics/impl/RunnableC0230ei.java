package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0230ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f864a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ Ci d;

    public RunnableC0230ei(Ci ci, String str, String str2, Throwable th) {
        this.d = ci;
        this.f864a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.d;
        Ci.a(ci.f392a, ci.d, ci.e).reportError(this.f864a, this.b, this.c);
    }
}
