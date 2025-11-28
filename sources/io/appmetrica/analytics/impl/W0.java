package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f739a;
    public final /* synthetic */ C0561s1 b;

    public W0(C0561s1 c0561s1, AdRevenue adRevenue) {
        this.b = c0561s1;
        this.f739a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportAdRevenue(this.f739a);
    }
}
