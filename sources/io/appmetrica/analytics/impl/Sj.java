package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class Sj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f674a;

    public Sj(Revenue revenue) {
        this.f674a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportRevenue(this.f674a);
    }
}
