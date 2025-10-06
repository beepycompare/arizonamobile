package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f707a;
    public final /* synthetic */ C0548r1 b;

    public V0(C0548r1 c0548r1, AdRevenue adRevenue) {
        this.b = c0548r1;
        this.f707a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).reportAdRevenue(this.f707a);
    }
}
