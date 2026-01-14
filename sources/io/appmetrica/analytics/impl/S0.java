package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f774a;
    public final /* synthetic */ C0589t1 b;

    public S0(C0589t1 c0589t1, boolean z) {
        this.b = c0589t1;
        this.f774a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0738z0 c0738z0 = this.b.f1229a;
        boolean z = this.f774a;
        c0738z0.getClass();
        C0713y0.c().setDataSendingEnabled(z);
    }
}
