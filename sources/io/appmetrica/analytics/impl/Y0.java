package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class Y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f758a;
    public final /* synthetic */ C0611u1 b;

    public Y0(C0611u1 c0611u1, AdRevenue adRevenue) {
        this.b = c0611u1;
        this.f758a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportAdRevenue(this.f758a);
    }
}
