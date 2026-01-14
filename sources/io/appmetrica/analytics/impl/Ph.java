package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Ph implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f740a;
    public final /* synthetic */ C0279gi b;

    public Ph(C0279gi c0279gi, AdRevenue adRevenue) {
        this.b = c0279gi;
        this.f740a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportAdRevenue(this.f740a);
    }
}
