package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0488p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0539r0 f1144a;

    public RunnableC0488p0(C0539r0 c0539r0) {
        this.f1144a = c0539r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0539r0 c0539r0 = this.f1144a;
        synchronized (c0539r0) {
            if (c0539r0.f1178a != null && c0539r0.a()) {
                try {
                    c0539r0.d = null;
                    c0539r0.f1178a.unbindService(c0539r0.j);
                } catch (Throwable unused) {
                }
            }
            c0539r0.d = null;
        }
    }
}
