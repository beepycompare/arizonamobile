package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class Kj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f525a;

    public Kj(ECommerceEvent eCommerceEvent) {
        this.f525a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportECommerce(this.f525a);
    }
}
