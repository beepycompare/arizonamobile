package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f633a;
    public final /* synthetic */ C0494p1 b;

    public T0(C0494p1 c0494p1, AdRevenue adRevenue) {
        this.b = c0494p1;
        this.f633a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.b).reportAdRevenue(this.f633a);
    }
}
