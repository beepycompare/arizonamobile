package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f869a;
    public final /* synthetic */ C0610u1 b;

    public Z0(C0610u1 c0610u1, ECommerceEvent eCommerceEvent) {
        this.b = c0610u1;
        this.f869a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportECommerce(this.f869a);
    }
}
