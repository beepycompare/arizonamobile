package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f855a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0278gi c;

    public Xh(C0278gi c0278gi, AdRevenue adRevenue, boolean z) {
        this.c = c0278gi;
        this.f855a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.c;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportAdRevenue(this.f855a, this.b);
    }
}
