package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes4.dex */
public final class Jj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f509a;

    public Jj(Revenue revenue) {
        this.f509a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportRevenue(this.f509a);
    }
}
