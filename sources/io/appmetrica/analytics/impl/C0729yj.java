package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0729yj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1222a;

    public C0729yj(ECommerceEvent eCommerceEvent) {
        this.f1222a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportECommerce(this.f1222a);
    }
}
