package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Tj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f656a;
    public final /* synthetic */ boolean b;

    public Tj(AdRevenue adRevenue, boolean z) {
        this.f656a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportAdRevenue(this.f656a, this.b);
    }
}
