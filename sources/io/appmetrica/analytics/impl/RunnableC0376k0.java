package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0376k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0426m0 f897a;

    public RunnableC0376k0(C0426m0 c0426m0) {
        this.f897a = c0426m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0426m0 c0426m0 = this.f897a;
        synchronized (c0426m0) {
            if (c0426m0.f929a != null && c0426m0.a()) {
                try {
                    c0426m0.d = null;
                    c0426m0.f929a.unbindService(c0426m0.i);
                } catch (Throwable unused) {
                }
            }
            c0426m0.d = null;
        }
    }
}
