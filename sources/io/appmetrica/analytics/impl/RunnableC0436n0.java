package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0436n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0486p0 f1016a;

    public RunnableC0436n0(C0486p0 c0486p0) {
        this.f1016a = c0486p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0486p0 c0486p0 = this.f1016a;
        synchronized (c0486p0) {
            if (c0486p0.f1047a != null && c0486p0.a()) {
                try {
                    c0486p0.d = null;
                    c0486p0.f1047a.unbindService(c0486p0.i);
                } catch (Throwable unused) {
                }
            }
            c0486p0.d = null;
        }
    }
}
