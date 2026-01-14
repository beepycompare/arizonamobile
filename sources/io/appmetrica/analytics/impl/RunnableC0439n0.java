package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0439n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0489p0 f1127a;

    public RunnableC0439n0(C0489p0 c0489p0) {
        this.f1127a = c0489p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0489p0 c0489p0 = this.f1127a;
        synchronized (c0489p0) {
            if (c0489p0.f1165a != null && c0489p0.a()) {
                try {
                    c0489p0.d = null;
                    c0489p0.f1165a.unbindService(c0489p0.j);
                } catch (Throwable unused) {
                }
            }
            c0489p0.d = null;
        }
    }
}
