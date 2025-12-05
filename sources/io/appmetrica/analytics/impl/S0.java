package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f751a;
    public final /* synthetic */ C0610u1 b;

    public S0(C0610u1 c0610u1, boolean z) {
        this.b = c0610u1;
        this.f751a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.b.f1224a;
        boolean z = this.f751a;
        c0734z0.getClass();
        C0709y0.c().a(z, true);
    }
}
