package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Tj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f657a;
    public final /* synthetic */ boolean b;

    public Tj(AdRevenue adRevenue, boolean z) {
        this.f657a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportAdRevenue(this.f657a, this.b);
    }
}
