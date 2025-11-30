package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f680a;
    public final /* synthetic */ C0301hi b;

    public Sh(C0301hi c0301hi, ECommerceEvent eCommerceEvent) {
        this.b = c0301hi;
        this.f680a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportECommerce(this.f680a);
    }
}
