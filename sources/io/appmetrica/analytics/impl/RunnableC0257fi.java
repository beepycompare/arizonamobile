package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0257fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f881a;
    public final /* synthetic */ Ci b;

    public RunnableC0257fi(Ci ci, Throwable th) {
        this.b = ci;
        this.f881a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportUnhandledException(this.f881a);
    }
}
