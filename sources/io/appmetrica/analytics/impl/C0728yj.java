package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0728yj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1319a;

    public C0728yj(ECommerceEvent eCommerceEvent) {
        this.f1319a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportECommerce(this.f1319a);
    }
}
