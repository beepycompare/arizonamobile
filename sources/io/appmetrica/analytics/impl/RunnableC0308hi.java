package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0308hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f890a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0308hi(C0735yi c0735yi, AdRevenue adRevenue) {
        this.b = c0735yi;
        this.f890a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportAdRevenue(this.f890a);
    }
}
