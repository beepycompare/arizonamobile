package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0182ck implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f828a;
    public final /* synthetic */ boolean b;

    public C0182ck(AdRevenue adRevenue, boolean z) {
        this.f828a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportAdRevenue(this.f828a, this.b);
    }
}
