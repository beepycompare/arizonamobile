package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0108a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f879a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0108a1(C0651v1 c0651v1, ECommerceEvent eCommerceEvent) {
        this.b = c0651v1;
        this.f879a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).reportECommerce(this.f879a);
    }
}
