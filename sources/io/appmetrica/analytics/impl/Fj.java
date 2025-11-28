package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Fj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f477a;

    public Fj(AdRevenue adRevenue) {
        this.f477a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportAdRevenue(this.f477a);
    }
}
