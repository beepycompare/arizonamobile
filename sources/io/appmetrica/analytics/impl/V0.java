package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f819a;
    public final /* synthetic */ C0589t1 b;

    public V0(C0589t1 c0589t1, Revenue revenue) {
        this.b = c0589t1;
        this.f819a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportRevenue(this.f819a);
    }
}
