package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0134ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdRevenue f756a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0134ai(C0560ri c0560ri, AdRevenue adRevenue) {
        this.b = c0560ri;
        this.f756a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportAdRevenue(this.f756a);
    }
}
