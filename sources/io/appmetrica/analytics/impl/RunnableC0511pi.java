package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0511pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1014a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0735yi c;

    public RunnableC0511pi(C0735yi c0735yi, AdRevenue adRevenue, boolean z) {
        this.c = c0735yi;
        this.f1014a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.c;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportAdRevenue(this.f1014a, this.b);
    }
}
