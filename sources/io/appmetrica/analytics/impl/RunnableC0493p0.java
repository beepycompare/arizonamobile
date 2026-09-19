package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0493p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0544r0 f1141a;

    public RunnableC0493p0(C0544r0 c0544r0) {
        this.f1141a = c0544r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0544r0 c0544r0 = this.f1141a;
        synchronized (c0544r0) {
            if (c0544r0.f1175a != null && c0544r0.a()) {
                try {
                    c0544r0.d = null;
                    c0544r0.f1175a.unbindService(c0544r0.j);
                } catch (Throwable unused) {
                }
            }
            c0544r0.d = null;
        }
    }
}
