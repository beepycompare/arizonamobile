package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0388ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f927a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0612ti c;

    public RunnableC0388ki(C0612ti c0612ti, AdRevenue adRevenue, boolean z) {
        this.c = c0612ti;
        this.f927a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.c;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportAdRevenue(this.f927a, this.b);
    }
}
