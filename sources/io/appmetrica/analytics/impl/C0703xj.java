package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0703xj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f1285a;

    public C0703xj(Revenue revenue) {
        this.f1285a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportRevenue(this.f1285a);
    }
}
