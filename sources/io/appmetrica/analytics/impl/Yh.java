package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f865a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0300hi c;

    public Yh(C0300hi c0300hi, AdRevenue adRevenue, boolean z) {
        this.c = c0300hi;
        this.f865a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1024a, c0300hi.d, c0300hi.e).reportAdRevenue(this.f865a, this.b);
    }
}
