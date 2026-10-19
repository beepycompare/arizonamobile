package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f869a;
    public final /* synthetic */ C0644v1 b;

    public Z0(C0644v1 c0644v1, AdRevenue adRevenue) {
        this.b = c0644v1;
        this.f869a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).reportAdRevenue(this.f869a);
    }
}
