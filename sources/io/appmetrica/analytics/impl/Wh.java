package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes3.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f745a;
    public final /* synthetic */ C0404li b;

    public Wh(C0404li c0404li, ECommerceEvent eCommerceEvent) {
        this.b = c0404li;
        this.f745a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportECommerce(this.f745a);
    }
}
