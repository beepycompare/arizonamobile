package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0419m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0471o0 f982a;

    public RunnableC0419m0(C0471o0 c0471o0) {
        this.f982a = c0471o0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0471o0 c0471o0 = this.f982a;
        synchronized (c0471o0) {
            if (c0471o0.f1012a != null && c0471o0.a()) {
                try {
                    c0471o0.d = null;
                    c0471o0.f1012a.unbindService(c0471o0.i);
                } catch (Throwable unused) {
                }
            }
            c0471o0.d = null;
        }
    }
}
