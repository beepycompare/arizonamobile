package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0181ck implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f823a;
    public final /* synthetic */ boolean b;

    public C0181ck(AdRevenue adRevenue, boolean z) {
        this.f823a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportAdRevenue(this.f823a, this.b);
    }
}
