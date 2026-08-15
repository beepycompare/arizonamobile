package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f866a;
    public final /* synthetic */ C0650v1 b;

    public Z0(C0650v1 c0650v1, AdRevenue adRevenue) {
        this.b = c0650v1;
        this.f866a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).reportAdRevenue(this.f866a);
    }
}
