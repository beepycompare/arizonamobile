package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0106a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f881a;
    public final /* synthetic */ C0649v1 b;

    public RunnableC0106a1(C0649v1 c0649v1, ECommerceEvent eCommerceEvent) {
        this.b = c0649v1;
        this.f881a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1.a(this.b).reportECommerce(this.f881a);
    }
}
