package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Hj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f617a;
    public final /* synthetic */ boolean b;

    public Hj(AdRevenue adRevenue, boolean z) {
        this.f617a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportAdRevenue(this.f617a, this.b);
    }
}
