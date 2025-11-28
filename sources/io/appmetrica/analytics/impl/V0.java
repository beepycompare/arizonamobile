package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f726a;
    public final /* synthetic */ C0561s1 b;

    public V0(C0561s1 c0561s1, Revenue revenue) {
        this.b = c0561s1;
        this.f726a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportRevenue(this.f726a);
    }
}
