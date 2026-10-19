package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Xj implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f845a;

    public Xj(ECommerceEvent eCommerceEvent) {
        this.f845a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportECommerce(this.f845a);
    }
}
