package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0300hi f670a;

    public Lh(C0300hi c0300hi) {
        this.f670a = c0300hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.f670a;
        C0300hi.a(c0300hi.f1024a, c0300hi.d, c0300hi.e).resumeSession();
    }
}
