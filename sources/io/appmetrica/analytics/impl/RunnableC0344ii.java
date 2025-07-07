package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0344ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f878a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0568ri c;

    public RunnableC0344ii(C0568ri c0568ri, AdRevenue adRevenue, boolean z) {
        this.c = c0568ri;
        this.f878a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.c;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportAdRevenue(this.f878a, this.b);
    }
}
