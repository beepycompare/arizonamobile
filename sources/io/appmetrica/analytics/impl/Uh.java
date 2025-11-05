package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes3.dex */
public final class Uh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f720a;
    public final /* synthetic */ C0404li b;

    public Uh(C0404li c0404li, AdRevenue adRevenue) {
        this.b = c0404li;
        this.f720a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportAdRevenue(this.f720a);
    }
}
