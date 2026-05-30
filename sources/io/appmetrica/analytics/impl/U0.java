package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f784a;
    public final /* synthetic */ C0651v1 b;

    public U0(C0651v1 c0651v1, boolean z) {
        this.b = c0651v1;
        this.f784a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1241a;
        boolean z = this.f784a;
        b0.getClass();
        A0.c().setDataSendingEnabled(z);
    }
}
