package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0301hk implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1025a;
    public final /* synthetic */ boolean b;

    public C0301hk(AdRevenue adRevenue, boolean z) {
        this.f1025a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.reportAdRevenue(this.f1025a, this.b);
    }
}
