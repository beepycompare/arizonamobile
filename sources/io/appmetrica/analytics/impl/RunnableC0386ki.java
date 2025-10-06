package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0386ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Revenue f956a;
    public final /* synthetic */ Ci b;

    public RunnableC0386ki(Ci ci, Revenue revenue) {
        this.b = ci;
        this.f956a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportRevenue(this.f956a);
    }
}
