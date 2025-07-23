package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0160bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f785a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0160bi(C0612ti c0612ti, Revenue revenue) {
        this.b = c0612ti;
        this.f785a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportRevenue(this.f785a);
    }
}
