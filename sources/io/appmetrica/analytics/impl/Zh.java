package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Rn f781a;
    public final /* synthetic */ C0301hi b;

    public Zh(C0301hi c0301hi, Rn rn) {
        this.b = c0301hi;
        this.f781a = rn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).a(this.f781a);
    }
}
