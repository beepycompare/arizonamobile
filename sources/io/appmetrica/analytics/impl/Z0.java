package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f771a;
    public final /* synthetic */ C0611u1 b;

    public Z0(C0611u1 c0611u1, ECommerceEvent eCommerceEvent) {
        this.b = c0611u1;
        this.f771a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportECommerce(this.f771a);
    }
}
