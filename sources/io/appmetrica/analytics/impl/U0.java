package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f687a;
    public final /* synthetic */ C0547r1 b;

    public U0(C0547r1 c0547r1, Revenue revenue) {
        this.b = c0547r1;
        this.f687a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportRevenue(this.f687a);
    }
}
