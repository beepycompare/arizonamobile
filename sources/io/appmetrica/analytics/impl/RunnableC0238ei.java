package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0238ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f832a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0238ei(C0613ti c0613ti, ECommerceEvent eCommerceEvent) {
        this.b = c0613ti;
        this.f832a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportECommerce(this.f832a);
    }
}
