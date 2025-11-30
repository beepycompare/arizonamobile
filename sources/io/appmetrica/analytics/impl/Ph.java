package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Ph implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f636a;
    public final /* synthetic */ C0301hi b;

    public Ph(C0301hi c0301hi, Revenue revenue) {
        this.b = c0301hi;
        this.f636a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportRevenue(this.f636a);
    }
}
