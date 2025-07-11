package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0336ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f879a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0560ri c;

    public RunnableC0336ii(C0560ri c0560ri, AdRevenue adRevenue, boolean z) {
        this.c = c0560ri;
        this.f879a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.c;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportAdRevenue(this.f879a, this.b);
    }
}
