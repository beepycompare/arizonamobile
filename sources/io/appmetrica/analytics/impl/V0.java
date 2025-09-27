package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f707a;
    public final /* synthetic */ C0547r1 b;

    public V0(C0547r1 c0547r1, AdRevenue adRevenue) {
        this.b = c0547r1;
        this.f707a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).reportAdRevenue(this.f707a);
    }
}
