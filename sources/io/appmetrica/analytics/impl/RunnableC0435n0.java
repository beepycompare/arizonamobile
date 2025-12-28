package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0435n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0485p0 f1116a;

    public RunnableC0435n0(C0485p0 c0485p0) {
        this.f1116a = c0485p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0485p0 c0485p0 = this.f1116a;
        synchronized (c0485p0) {
            if (c0485p0.f1155a != null && c0485p0.a()) {
                try {
                    c0485p0.d = null;
                    c0485p0.f1155a.unbindService(c0485p0.j);
                } catch (Throwable unused) {
                }
            }
            c0485p0.d = null;
        }
    }
}
