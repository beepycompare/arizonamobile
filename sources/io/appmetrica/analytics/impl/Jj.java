package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class Jj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f510a;

    public Jj(Revenue revenue) {
        this.f510a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportRevenue(this.f510a);
    }
}
