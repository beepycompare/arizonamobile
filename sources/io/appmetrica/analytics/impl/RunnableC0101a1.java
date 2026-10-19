package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0101a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f884a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0101a1(C0644v1 c0644v1, ECommerceEvent eCommerceEvent) {
        this.b = c0644v1;
        this.f884a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportECommerce(this.f884a);
    }
}
