package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0370k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0420m0 f919a;

    public RunnableC0370k0(C0420m0 c0420m0) {
        this.f919a = c0420m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0420m0 c0420m0 = this.f919a;
        synchronized (c0420m0) {
            if (c0420m0.f945a != null && c0420m0.a()) {
                try {
                    c0420m0.d = null;
                    c0420m0.f945a.unbindService(c0420m0.i);
                } catch (Throwable unused) {
                }
            }
            c0420m0.d = null;
        }
    }
}
