package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0205di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f847a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ Ci c;

    public RunnableC0205di(Ci ci, String str, Throwable th) {
        this.c = ci;
        this.f847a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f393a, ci.d, ci.e).reportError(this.f847a, this.b);
    }
}
