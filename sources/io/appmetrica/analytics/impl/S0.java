package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f773a;
    public final /* synthetic */ C0588t1 b;

    public S0(C0588t1 c0588t1, boolean z) {
        this.b = c0588t1;
        this.f773a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0737z0 c0737z0 = this.b.f1228a;
        boolean z = this.f773a;
        c0737z0.getClass();
        C0712y0.c().setDataSendingEnabled(z);
    }
}
