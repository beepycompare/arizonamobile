package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0350ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f1056a;
    public final /* synthetic */ Ai b;

    public RunnableC0350ji(Ai ai, AdRevenue adRevenue) {
        this.b = ai;
        this.f1056a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f466a, ai.d, ai.e).reportAdRevenue(this.f1056a);
    }
}
