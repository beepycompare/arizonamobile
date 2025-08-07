package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0389ki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f927a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0613ti c;

    public RunnableC0389ki(C0613ti c0613ti, AdRevenue adRevenue, boolean z) {
        this.c = c0613ti;
        this.f927a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportAdRevenue(this.f927a, this.b);
    }
}
