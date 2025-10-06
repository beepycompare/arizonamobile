package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class Tj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f689a;

    public Tj(ECommerceEvent eCommerceEvent) {
        this.f689a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportECommerce(this.f689a);
    }
}
