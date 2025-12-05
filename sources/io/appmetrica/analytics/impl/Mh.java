package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0300hi f674a;

    public Mh(C0300hi c0300hi) {
        this.f674a = c0300hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.f674a;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).pauseSession();
    }
}
