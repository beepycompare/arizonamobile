package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f662a;
    public final /* synthetic */ C0496p1 b;

    public U0(C0496p1 c0496p1, ECommerceEvent eCommerceEvent) {
        this.b = c0496p1;
        this.f662a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).reportECommerce(this.f662a);
    }
}
