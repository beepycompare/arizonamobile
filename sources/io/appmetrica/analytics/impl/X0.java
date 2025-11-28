package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f748a;
    public final /* synthetic */ C0561s1 b;

    public X0(C0561s1 c0561s1, ECommerceEvent eCommerceEvent) {
        this.b = c0561s1;
        this.f748a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportECommerce(this.f748a);
    }
}
