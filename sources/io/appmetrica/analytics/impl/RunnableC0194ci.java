package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0194ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f786a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0194ci(C0568ri c0568ri, ECommerceEvent eCommerceEvent) {
        this.b = c0568ri;
        this.f786a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportECommerce(this.f786a);
    }
}
