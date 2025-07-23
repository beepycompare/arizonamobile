package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0237ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f832a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0237ei(C0612ti c0612ti, ECommerceEvent eCommerceEvent) {
        this.b = c0612ti;
        this.f832a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportECommerce(this.f832a);
    }
}
