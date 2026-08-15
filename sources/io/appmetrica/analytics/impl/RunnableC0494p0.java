package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0494p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0545r0 f1141a;

    public RunnableC0494p0(C0545r0 c0545r0) {
        this.f1141a = c0545r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0545r0 c0545r0 = this.f1141a;
        synchronized (c0545r0) {
            if (c0545r0.f1175a != null && c0545r0.a()) {
                try {
                    c0545r0.d = null;
                    c0545r0.f1175a.unbindService(c0545r0.j);
                } catch (Throwable unused) {
                }
            }
            c0545r0.d = null;
        }
    }
}
