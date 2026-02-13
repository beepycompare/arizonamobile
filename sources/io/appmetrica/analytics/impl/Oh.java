package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Oh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f725a;
    public final /* synthetic */ C0279gi b;

    public Oh(C0279gi c0279gi, Revenue revenue) {
        this.b = c0279gi;
        this.f725a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportRevenue(this.f725a);
    }
}
