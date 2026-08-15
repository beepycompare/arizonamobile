package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f786a;
    public final /* synthetic */ C0650v1 b;

    public U0(C0650v1 c0650v1, boolean z) {
        this.b = c0650v1;
        this.f786a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1243a;
        boolean z = this.f786a;
        b0.getClass();
        A0.c().setDataSendingEnabled(z);
    }
}
