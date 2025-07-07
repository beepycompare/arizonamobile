package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f617a;
    public final /* synthetic */ C0502p1 b;

    public S0(C0502p1 c0502p1, Revenue revenue) {
        this.b = c0502p1;
        this.f617a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportRevenue(this.f617a);
    }
}
