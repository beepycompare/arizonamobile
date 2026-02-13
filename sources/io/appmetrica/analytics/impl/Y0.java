package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f859a;
    public final /* synthetic */ C0589t1 b;

    public Y0(C0589t1 c0589t1, ECommerceEvent eCommerceEvent) {
        this.b = c0589t1;
        this.f859a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportECommerce(this.f859a);
    }
}
