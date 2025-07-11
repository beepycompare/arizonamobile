package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class Hj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f464a;

    public Hj(ECommerceEvent eCommerceEvent) {
        this.f464a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportECommerce(this.f464a);
    }
}
