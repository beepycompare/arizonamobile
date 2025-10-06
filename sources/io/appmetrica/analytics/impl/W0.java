package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f720a;
    public final /* synthetic */ C0548r1 b;

    public W0(C0548r1 c0548r1, ECommerceEvent eCommerceEvent) {
        this.b = c0548r1;
        this.f720a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).reportECommerce(this.f720a);
    }
}
