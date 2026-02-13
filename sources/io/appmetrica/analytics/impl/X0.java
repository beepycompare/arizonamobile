package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* loaded from: classes5.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f846a;
    public final /* synthetic */ C0589t1 b;

    public X0(C0589t1 c0589t1, AdRevenue adRevenue) {
        this.b = c0589t1;
        this.f846a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportAdRevenue(this.f846a);
    }
}
