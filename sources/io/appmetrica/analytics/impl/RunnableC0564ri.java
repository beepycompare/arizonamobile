package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0564ri implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1186a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Ai c;

    public RunnableC0564ri(Ai ai, AdRevenue adRevenue, boolean z) {
        this.c = ai;
        this.f1186a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f463a, ai.d, ai.e).reportAdRevenue(this.f1186a, this.b);
    }
}
