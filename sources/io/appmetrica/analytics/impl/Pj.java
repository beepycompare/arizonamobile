package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class Pj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f608a;

    public Pj(ECommerceEvent eCommerceEvent) {
        this.f608a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportECommerce(this.f608a);
    }
}
