package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Kj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f507a;

    public Kj(AdRevenue adRevenue) {
        this.f507a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportAdRevenue(this.f507a);
    }
}
