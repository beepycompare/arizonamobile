package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0306hk implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1022a;
    public final /* synthetic */ boolean b;

    public C0306hk(AdRevenue adRevenue, boolean z) {
        this.f1022a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportAdRevenue(this.f1022a, this.b);
    }
}
