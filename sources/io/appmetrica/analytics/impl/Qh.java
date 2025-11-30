package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Qh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f651a;
    public final /* synthetic */ C0301hi b;

    public Qh(C0301hi c0301hi, AdRevenue adRevenue) {
        this.b = c0301hi;
        this.f651a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportAdRevenue(this.f651a);
    }
}
