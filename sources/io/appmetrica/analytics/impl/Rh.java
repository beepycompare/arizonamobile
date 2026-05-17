package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes5.dex */
public final class Rh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f773a;
    public final /* synthetic */ C0278gi b;

    public Rh(C0278gi c0278gi, ECommerceEvent eCommerceEvent) {
        this.b = c0278gi;
        this.f773a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportECommerce(this.f773a);
    }
}
