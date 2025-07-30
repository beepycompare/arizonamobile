package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Nj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f567a;

    public Nj(AdRevenue adRevenue) {
        this.f567a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportAdRevenue(this.f567a);
    }
}
