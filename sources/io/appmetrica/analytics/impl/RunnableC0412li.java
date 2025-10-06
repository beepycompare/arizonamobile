package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0412li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f975a;
    public final /* synthetic */ Ci b;

    public RunnableC0412li(Ci ci, AdRevenue adRevenue) {
        this.b = ci;
        this.f975a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportAdRevenue(this.f975a);
    }
}
