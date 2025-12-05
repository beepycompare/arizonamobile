package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Ij implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f610a;
    public final /* synthetic */ boolean b;

    public Ij(AdRevenue adRevenue, boolean z) {
        this.f610a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportAdRevenue(this.f610a, this.b);
    }
}
