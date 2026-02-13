package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f855a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0279gi c;

    public Xh(C0279gi c0279gi, AdRevenue adRevenue, boolean z) {
        this.c = c0279gi;
        this.f855a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportAdRevenue(this.f855a, this.b);
    }
}
