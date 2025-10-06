package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0464ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f1007a;
    public final /* synthetic */ Ci b;

    public RunnableC0464ni(Ci ci, ECommerceEvent eCommerceEvent) {
        this.b = ci;
        this.f1007a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportECommerce(this.f1007a);
    }
}
