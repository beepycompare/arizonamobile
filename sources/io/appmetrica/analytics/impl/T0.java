package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes4.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f632a;
    public final /* synthetic */ C0502p1 b;

    public T0(C0502p1 c0502p1, AdRevenue adRevenue) {
        this.b = c0502p1;
        this.f632a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.b).reportAdRevenue(this.f632a);
    }
}
