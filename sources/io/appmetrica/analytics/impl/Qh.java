package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Qh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f734a;
    public final /* synthetic */ C0300hi b;

    public Qh(C0300hi c0300hi, AdRevenue adRevenue) {
        this.b = c0300hi;
        this.f734a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).reportAdRevenue(this.f734a);
    }
}
