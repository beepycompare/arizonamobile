package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes3.dex */
public final class Cj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f428a;

    public Cj(ECommerceEvent eCommerceEvent) {
        this.f428a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportECommerce(this.f428a);
    }
}
