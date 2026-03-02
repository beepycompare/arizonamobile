package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f818a;
    public final /* synthetic */ C0588t1 b;

    public V0(C0588t1 c0588t1, Revenue revenue) {
        this.b = c0588t1;
        this.f818a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).reportRevenue(this.f818a);
    }
}
