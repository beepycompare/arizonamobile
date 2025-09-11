package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0256fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f880a;
    public final /* synthetic */ Ci b;

    public RunnableC0256fi(Ci ci, Throwable th) {
        this.b = ci;
        this.f880a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f392a, ci.d, ci.e).reportUnhandledException(this.f880a);
    }
}
