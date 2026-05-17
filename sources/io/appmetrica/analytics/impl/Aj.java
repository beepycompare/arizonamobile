package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Aj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f506a;

    public Aj(AdRevenue adRevenue) {
        this.f506a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.reportAdRevenue(this.f506a);
    }
}
