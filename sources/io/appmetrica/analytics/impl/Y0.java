package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f864a;
    public final /* synthetic */ C0588t1 b;

    public Y0(C0588t1 c0588t1, ECommerceEvent eCommerceEvent) {
        this.b = c0588t1;
        this.f864a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).reportECommerce(this.f864a);
    }
}
