package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f692a;
    public final /* synthetic */ C0548r1 b;

    public U0(C0548r1 c0548r1, Revenue revenue) {
        this.b = c0548r1;
        this.f692a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).reportRevenue(this.f692a);
    }
}
