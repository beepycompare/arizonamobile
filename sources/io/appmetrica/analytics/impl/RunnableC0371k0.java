package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0371k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0421m0 f919a;

    public RunnableC0371k0(C0421m0 c0421m0) {
        this.f919a = c0421m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0421m0 c0421m0 = this.f919a;
        synchronized (c0421m0) {
            if (c0421m0.f945a != null && c0421m0.a()) {
                try {
                    c0421m0.d = null;
                    c0421m0.f945a.unbindService(c0421m0.i);
                } catch (Throwable unused) {
                }
            }
            c0421m0.d = null;
        }
    }
}
