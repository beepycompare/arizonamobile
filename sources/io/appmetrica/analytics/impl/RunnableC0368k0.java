package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0368k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0418m0 f898a;

    public RunnableC0368k0(C0418m0 c0418m0) {
        this.f898a = c0418m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0418m0 c0418m0 = this.f898a;
        synchronized (c0418m0) {
            if (c0418m0.f930a != null && c0418m0.a()) {
                try {
                    c0418m0.d = null;
                    c0418m0.f930a.unbindService(c0418m0.i);
                } catch (Throwable unused) {
                }
            }
            c0418m0.d = null;
        }
    }
}
