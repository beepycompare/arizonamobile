package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0186ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f799a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0186ci(C0612ti c0612ti, AdRevenue adRevenue) {
        this.b = c0612ti;
        this.f799a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportAdRevenue(this.f799a);
    }
}
