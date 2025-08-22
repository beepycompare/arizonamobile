package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0359ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f926a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0359ji(C0735yi c0735yi, ECommerceEvent eCommerceEvent) {
        this.b = c0735yi;
        this.f926a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportECommerce(this.f926a);
    }
}
