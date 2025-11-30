package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f767a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0301hi c;

    public Yh(C0301hi c0301hi, AdRevenue adRevenue, boolean z) {
        this.c = c0301hi;
        this.f767a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.c;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportAdRevenue(this.f767a, this.b);
    }
}
