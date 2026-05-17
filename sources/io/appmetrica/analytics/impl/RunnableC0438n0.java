package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0438n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0488p0 f1131a;

    public RunnableC0438n0(C0488p0 c0488p0) {
        this.f1131a = c0488p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0488p0 c0488p0 = this.f1131a;
        synchronized (c0488p0) {
            if (c0488p0.f1169a != null && c0488p0.a()) {
                try {
                    c0488p0.d = null;
                    c0488p0.f1169a.unbindService(c0488p0.j);
                } catch (Throwable unused) {
                }
            }
            c0488p0.d = null;
        }
    }
}
