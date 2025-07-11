package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f618a;
    public final /* synthetic */ C0494p1 b;

    public S0(C0494p1 c0494p1, Revenue revenue) {
        this.b = c0494p1;
        this.f618a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportRevenue(this.f618a);
    }
}
