package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0307hk implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1022a;
    public final /* synthetic */ boolean b;

    public C0307hk(AdRevenue adRevenue, boolean z) {
        this.f1022a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportAdRevenue(this.f1022a, this.b);
    }
}
