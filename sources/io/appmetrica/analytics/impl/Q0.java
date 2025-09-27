package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f633a;
    public final /* synthetic */ C0547r1 b;

    public Q0(C0547r1 c0547r1, boolean z) {
        this.b = c0547r1;
        this.f633a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.b.f1059a;
        boolean z = this.f633a;
        c0671w0.getClass();
        C0646v0.c().setDataSendingEnabled(z);
    }
}
