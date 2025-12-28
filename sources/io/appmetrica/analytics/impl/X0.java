package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f841a;
    public final /* synthetic */ C0610u1 b;

    public X0(C0610u1 c0610u1, Revenue revenue) {
        this.b = c0610u1;
        this.f841a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportRevenue(this.f841a);
    }
}
