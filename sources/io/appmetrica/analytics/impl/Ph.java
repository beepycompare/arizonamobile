package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Ph implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f739a;
    public final /* synthetic */ C0278gi b;

    public Ph(C0278gi c0278gi, AdRevenue adRevenue) {
        this.b = c0278gi;
        this.f739a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportAdRevenue(this.f739a);
    }
}
