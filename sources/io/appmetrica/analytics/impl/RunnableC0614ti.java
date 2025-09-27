package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ti  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0614ti implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1098a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Ci c;

    public RunnableC0614ti(Ci ci, AdRevenue adRevenue, boolean z) {
        this.c = ci;
        this.f1098a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f393a, ci.d, ci.e).reportAdRevenue(this.f1098a, this.b);
    }
}
