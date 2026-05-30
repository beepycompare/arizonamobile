package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.p0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0495p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0546r0 f1139a;

    public RunnableC0495p0(C0546r0 c0546r0) {
        this.f1139a = c0546r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0546r0 c0546r0 = this.f1139a;
        synchronized (c0546r0) {
            if (c0546r0.f1173a != null && c0546r0.a()) {
                try {
                    c0546r0.d = null;
                    c0546r0.f1173a.unbindService(c0546r0.j);
                } catch (Throwable unused) {
                }
            }
            c0546r0.d = null;
        }
    }
}
