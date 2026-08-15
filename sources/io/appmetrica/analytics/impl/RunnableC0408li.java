package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0408li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1084a;
    public final /* synthetic */ Ai b;

    public RunnableC0408li(Ai ai, ECommerceEvent eCommerceEvent) {
        this.b = ai;
        this.f1084a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).reportECommerce(this.f1084a);
    }
}
