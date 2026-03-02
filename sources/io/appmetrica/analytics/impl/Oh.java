package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Oh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f725a;
    public final /* synthetic */ C0278gi b;

    public Oh(C0278gi c0278gi, Revenue revenue) {
        this.b = c0278gi;
        this.f725a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportRevenue(this.f725a);
    }
}
