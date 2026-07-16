package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f756a;
    public final /* synthetic */ C0651v1 b;

    public S0(C0651v1 c0651v1, boolean z) {
        this.b = c0651v1;
        this.f756a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1243a;
        boolean z = this.f756a;
        b0.getClass();
        A0.c().a(z);
    }
}
