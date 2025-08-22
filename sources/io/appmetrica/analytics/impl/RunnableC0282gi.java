package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0282gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f873a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0282gi(C0735yi c0735yi, Revenue revenue) {
        this.b = c0735yi;
        this.f873a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportRevenue(this.f873a);
    }
}
