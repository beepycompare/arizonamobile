package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f739a;
    public final /* synthetic */ C0560ri b;

    public Zh(C0560ri c0560ri, Revenue revenue) {
        this.b = c0560ri;
        this.f739a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportRevenue(this.f739a);
    }
}
