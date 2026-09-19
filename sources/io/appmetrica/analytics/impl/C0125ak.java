package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0125ak implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f892a;

    public C0125ak(AdRevenue adRevenue) {
        this.f892a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportAdRevenue(this.f892a);
    }
}
