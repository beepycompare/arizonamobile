package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Bj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f511a;

    public Bj(AdRevenue adRevenue) {
        this.f511a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.reportAdRevenue(this.f511a);
    }
}
