package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Rn f864a;
    public final /* synthetic */ C0300hi b;

    public Zh(C0300hi c0300hi, Rn rn) {
        this.b = c0300hi;
        this.f864a = rn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).a(this.f864a);
    }
}
