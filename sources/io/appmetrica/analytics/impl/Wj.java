package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Wj implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f725a;

    public Wj(AdRevenue adRevenue) {
        this.f725a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportAdRevenue(this.f725a);
    }
}
