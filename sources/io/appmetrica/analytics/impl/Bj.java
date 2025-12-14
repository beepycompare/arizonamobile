package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Bj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f510a;

    public Bj(AdRevenue adRevenue) {
        this.f510a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportAdRevenue(this.f510a);
    }
}
