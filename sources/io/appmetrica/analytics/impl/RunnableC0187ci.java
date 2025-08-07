package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0187ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f799a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0187ci(C0613ti c0613ti, AdRevenue adRevenue) {
        this.b = c0613ti;
        this.f799a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportAdRevenue(this.f799a);
    }
}
