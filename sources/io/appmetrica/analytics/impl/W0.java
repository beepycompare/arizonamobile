package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f719a;
    public final /* synthetic */ C0547r1 b;

    public W0(C0547r1 c0547r1, ECommerceEvent eCommerceEvent) {
        this.b = c0547r1;
        this.f719a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportECommerce(this.f719a);
    }
}
