package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Mj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f595a;
    public final /* synthetic */ boolean b;

    public Mj(AdRevenue adRevenue, boolean z) {
        this.f595a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportAdRevenue(this.f595a, this.b);
    }
}
