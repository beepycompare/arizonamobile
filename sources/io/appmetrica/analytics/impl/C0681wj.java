package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0681wj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f1294a;

    public C0681wj(Revenue revenue) {
        this.f1294a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportRevenue(this.f1294a);
    }
}
