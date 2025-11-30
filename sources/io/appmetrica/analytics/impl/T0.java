package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f685a;
    public final /* synthetic */ C0611u1 b;

    public T0(C0611u1 c0611u1, boolean z) {
        this.b = c0611u1;
        this.f685a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735z0 c0735z0 = this.b.f1141a;
        boolean z = this.f685a;
        c0735z0.getClass();
        C0710y0.c().setDataSendingEnabled(z);
    }
}
