package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class Hj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f463a;

    public Hj(ECommerceEvent eCommerceEvent) {
        this.f463a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportECommerce(this.f463a);
    }
}
