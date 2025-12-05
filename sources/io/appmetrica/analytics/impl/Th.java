package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f778a;
    public final /* synthetic */ C0300hi b;

    public Th(C0300hi c0300hi, boolean z) {
        this.b = c0300hi;
        this.f778a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).setDataSendingEnabled(this.f778a);
    }
}
