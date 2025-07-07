package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f560a;
    public final /* synthetic */ C0502p1 b;

    public O0(C0502p1 c0502p1, boolean z) {
        this.b = c0502p1;
        this.f560a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0625u0 c0625u0 = this.b.f983a;
        boolean z = this.f560a;
        c0625u0.getClass();
        C0600t0.c().setDataSendingEnabled(z);
    }
}
