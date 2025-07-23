package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class S0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f629a;
    public final /* synthetic */ C0496p1 b;

    public S0(C0496p1 c0496p1, Revenue revenue) {
        this.b = c0496p1;
        this.f629a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).reportRevenue(this.f629a);
    }
}
