package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f783a;
    public final /* synthetic */ C0610u1 b;

    public T0(C0610u1 c0610u1, boolean z) {
        this.b = c0610u1;
        this.f783a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.b.f1239a;
        boolean z = this.f783a;
        c0734z0.getClass();
        C0709y0.c().setDataSendingEnabled(z);
    }
}
