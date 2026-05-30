package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Wj implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f828a;

    public Wj(Revenue revenue) {
        this.f828a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportRevenue(this.f828a);
    }
}
