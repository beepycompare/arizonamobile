package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0172ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f832a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0404li c;

    public RunnableC0172ci(C0404li c0404li, AdRevenue adRevenue, boolean z) {
        this.c = c0404li;
        this.f832a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportAdRevenue(this.f832a, this.b);
    }
}
