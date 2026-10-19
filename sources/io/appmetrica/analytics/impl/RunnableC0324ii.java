package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0324ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f1040a;
    public final /* synthetic */ Ai b;

    public RunnableC0324ii(Ai ai, Revenue revenue) {
        this.b = ai;
        this.f1040a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f466a, ai.d, ai.e).reportRevenue(this.f1040a);
    }
}
