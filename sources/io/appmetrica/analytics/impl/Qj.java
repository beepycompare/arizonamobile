package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class Qj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f597a;
    public final /* synthetic */ boolean b;

    public Qj(AdRevenue adRevenue, boolean z) {
        this.f597a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportAdRevenue(this.f597a, this.b);
    }
}
