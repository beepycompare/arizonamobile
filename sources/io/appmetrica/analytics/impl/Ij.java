package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Ij implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f527a;
    public final /* synthetic */ boolean b;

    public Ij(AdRevenue adRevenue, boolean z) {
        this.f527a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportAdRevenue(this.f527a, this.b);
    }
}
