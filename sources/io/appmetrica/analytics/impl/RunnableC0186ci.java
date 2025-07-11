package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0186ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f787a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0186ci(C0560ri c0560ri, ECommerceEvent eCommerceEvent) {
        this.b = c0560ri;
        this.f787a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportECommerce(this.f787a);
    }
}
