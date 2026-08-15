package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Wj implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f830a;

    public Wj(Revenue revenue) {
        this.f830a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportRevenue(this.f830a);
    }
}
