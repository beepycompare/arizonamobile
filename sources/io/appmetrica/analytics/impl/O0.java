package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f561a;
    public final /* synthetic */ C0494p1 b;

    public O0(C0494p1 c0494p1, boolean z) {
        this.b = c0494p1;
        this.f561a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.b.f984a;
        boolean z = this.f561a;
        c0617u0.getClass();
        C0592t0.c().setDataSendingEnabled(z);
    }
}
