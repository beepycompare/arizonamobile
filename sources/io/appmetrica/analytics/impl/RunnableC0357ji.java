package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0357ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1051a;
    public final /* synthetic */ Ai b;

    public RunnableC0357ji(Ai ai, AdRevenue adRevenue) {
        this.b = ai;
        this.f1051a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f461a, ai.d, ai.e).reportAdRevenue(this.f1051a);
    }
}
