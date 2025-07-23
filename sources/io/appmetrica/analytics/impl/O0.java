package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f569a;
    public final /* synthetic */ C0496p1 b;

    public O0(C0496p1 c0496p1, boolean z) {
        this.b = c0496p1;
        this.f569a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.b.f994a;
        boolean z = this.f569a;
        c0619u0.getClass();
        C0594t0.c().setDataSendingEnabled(z);
    }
}
