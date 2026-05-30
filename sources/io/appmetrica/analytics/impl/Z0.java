package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f864a;
    public final /* synthetic */ C0651v1 b;

    public Z0(C0651v1 c0651v1, AdRevenue adRevenue) {
        this.b = c0651v1;
        this.f864a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.b).reportAdRevenue(this.f864a);
    }
}
