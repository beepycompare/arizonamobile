package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0161bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f785a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0161bi(C0613ti c0613ti, Revenue revenue) {
        this.b = c0613ti;
        this.f785a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportRevenue(this.f785a);
    }
}
