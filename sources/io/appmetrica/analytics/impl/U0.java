package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f649a;
    public final /* synthetic */ C0502p1 b;

    public U0(C0502p1 c0502p1, ECommerceEvent eCommerceEvent) {
        this.b = c0502p1;
        this.f649a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportECommerce(this.f649a);
    }
}
