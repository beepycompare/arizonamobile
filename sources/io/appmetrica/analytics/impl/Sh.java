package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f763a;
    public final /* synthetic */ C0300hi b;

    public Sh(C0300hi c0300hi, ECommerceEvent eCommerceEvent) {
        this.b = c0300hi;
        this.f763a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).reportECommerce(this.f763a);
    }
}
