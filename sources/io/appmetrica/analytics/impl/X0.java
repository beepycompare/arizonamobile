package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f834a;
    public final /* synthetic */ C0651v1 b;

    public X0(C0651v1 c0651v1, Revenue revenue) {
        this.b = c0651v1;
        this.f834a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).reportRevenue(this.f834a);
    }
}
