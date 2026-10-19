package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f839a;
    public final /* synthetic */ C0644v1 b;

    public X0(C0644v1 c0644v1, Revenue revenue) {
        this.b = c0644v1;
        this.f839a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportRevenue(this.f839a);
    }
}
