package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0706xj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1309a;

    public C0706xj(ECommerceEvent eCommerceEvent) {
        this.f1309a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportECommerce(this.f1309a);
    }
}
