package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Ph implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f733a;
    public final /* synthetic */ C0300hi b;

    public Ph(C0300hi c0300hi, Revenue revenue) {
        this.b = c0300hi;
        this.f733a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportRevenue(this.f733a);
    }
}
