package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0308hk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1019a;
    public final /* synthetic */ boolean b;

    public C0308hk(AdRevenue adRevenue, boolean z) {
        this.f1019a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportAdRevenue(this.f1019a, this.b);
    }
}
