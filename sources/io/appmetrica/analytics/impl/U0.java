package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* loaded from: classes4.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f650a;
    public final /* synthetic */ C0494p1 b;

    public U0(C0494p1 c0494p1, ECommerceEvent eCommerceEvent) {
        this.b = c0494p1;
        this.f650a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportECommerce(this.f650a);
    }
}
