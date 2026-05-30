package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0409li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1082a;
    public final /* synthetic */ Ai b;

    public RunnableC0409li(Ai ai, ECommerceEvent eCommerceEvent) {
        this.b = ai;
        this.f1082a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f461a, ai.d, ai.e).reportECommerce(this.f1082a);
    }
}
