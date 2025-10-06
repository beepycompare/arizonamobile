package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0420m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0472o0 f983a;

    public RunnableC0420m0(C0472o0 c0472o0) {
        this.f983a = c0472o0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0472o0 c0472o0 = this.f983a;
        synchronized (c0472o0) {
            if (c0472o0.f1013a != null && c0472o0.a()) {
                try {
                    c0472o0.d = null;
                    c0472o0.f1013a.unbindService(c0472o0.i);
                } catch (Throwable unused) {
                }
            }
            c0472o0.d = null;
        }
    }
}
