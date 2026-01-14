package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Rh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f769a;
    public final /* synthetic */ C0279gi b;

    public Rh(C0279gi c0279gi, ECommerceEvent eCommerceEvent) {
        this.b = c0279gi;
        this.f769a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportECommerce(this.f769a);
    }
}
