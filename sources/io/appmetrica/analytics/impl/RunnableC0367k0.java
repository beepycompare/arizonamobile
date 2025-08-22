package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0367k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0418m0 f931a;

    public RunnableC0367k0(C0418m0 c0418m0) {
        this.f931a = c0418m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0418m0 c0418m0 = this.f931a;
        synchronized (c0418m0) {
            if (c0418m0.f960a != null && c0418m0.a()) {
                try {
                    c0418m0.d = null;
                    c0418m0.f960a.unbindService(c0418m0.i);
                } catch (Throwable unused) {
                }
            }
            c0418m0.d = null;
        }
    }
}
