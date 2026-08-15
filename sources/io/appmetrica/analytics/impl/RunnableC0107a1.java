package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0107a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f881a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0107a1(C0650v1 c0650v1, ECommerceEvent eCommerceEvent) {
        this.b = c0650v1;
        this.f881a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportECommerce(this.f881a);
    }
}
