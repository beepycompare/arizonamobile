package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0127ak implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f889a;

    public C0127ak(AdRevenue adRevenue) {
        this.f889a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportAdRevenue(this.f889a);
    }
}
