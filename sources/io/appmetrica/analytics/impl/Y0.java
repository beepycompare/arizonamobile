package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f855a;
    public final /* synthetic */ C0610u1 b;

    public Y0(C0610u1 c0610u1, AdRevenue adRevenue) {
        this.b = c0610u1;
        this.f855a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).reportAdRevenue(this.f855a);
    }
}
