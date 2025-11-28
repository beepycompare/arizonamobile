package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* loaded from: classes5.dex */
public final class Bj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f415a;

    public Bj(Revenue revenue) {
        this.f415a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportRevenue(this.f415a);
    }
}
